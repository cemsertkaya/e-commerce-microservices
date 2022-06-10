package com.archTech.AuthService.service;
import com.archTech.AuthService.VO.User;
import com.archTech.AuthService.entity.AuthLogin;
import com.archTech.AuthService.entity.AuthSignUp;
import com.archTech.AuthService.entity.AuthUser;
import com.archTech.AuthService.repository.AuthRepository;
import com.archTech.AuthService.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class AuthService
{
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User signUp(AuthSignUp signUpAuth)
    {
        if (findUserByEmail(signUpAuth.getEmail()) != null) return null;

        AuthUser authUserToCreate = new AuthUser();
        authUserToCreate.setEmail(signUpAuth.getEmail());
        try {
            List<byte[]> generatedPasswords = generatePasswordHashAndSalt(signUpAuth.getPassword());
            authUserToCreate.setPasswordSalt(generatedPasswords.get(0));
            authUserToCreate.setPasswordHash(generatedPasswords.get(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        AuthUser createdUser = authRepository.save(authUserToCreate);
        HttpEntity<User> request = new HttpEntity<>(new User(createdUser.getUserId(),
                signUpAuth.getEmail(), signUpAuth.getFirstName(), signUpAuth.getLastName()));

        User user = restTemplate.postForObject("http://localhost:9002/users/", request, User.class);
        assert user != null;
        user.setToken(generateJWT(user));
        return user;
    }

    public User login(AuthLogin loginAuth)
    {
        AuthUser authUser = findUserByEmail(loginAuth.getEmail());
        if (authUser == null) return null;
        if (!verifyPassword(authUser, loginAuth.getPassword())) return null;

        User user = restTemplate.getForObject("http://localhost:9002/users/" + authUser.getUserId(), User.class);
        assert user != null;
        user.setToken(generateJWT(user));
        return user;
    }

    public AuthUser findUserByEmail(String email) {
        return authRepository.findUserByEmail(email);
    }

    private String generateJWT(User user) {
        return jwtTokenUtil.generateToken(user);
    }

    private List<byte[]> generatePasswordHashAndSalt(String password) {
        List<byte[]> result = new ArrayList<>();

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        result.add(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            result.add(hash);

            return result;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verifyPassword(AuthUser user, String password) {
        byte[] salt = user.getPasswordSalt();

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();

            return Arrays.equals(hash, user.getPasswordHash());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

}
