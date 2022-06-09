package com.archTech.CartService.service;
import com.archTech.CartService.entity.AuthLogin;
import com.archTech.CartService.entity.AuthSignUp;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class AuthService
{
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User signUp(AuthSignUp signUpAuth)
    {
        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
        parametersMap.add("firstName", signUpAuth.getFirstName());
        parametersMap.add("lastName", signUpAuth.getLastName());
        parametersMap.add("email", signUpAuth.getEmail());

        return restTemplate.postForObject("http://localhost:9002/user/", parametersMap, User.class);


    }

    public User login(AuthLogin loginAuth)
    {
        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
        parametersMap.add("email", loginAuth.getEmail());
        parametersMap.add("password", loginAuth.getPassword());

        return restTemplate.postForObject("http://localhost:9002/user/", parametersMap, User.class);
    }

}
