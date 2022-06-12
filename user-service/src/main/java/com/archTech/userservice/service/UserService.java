package com.archTech.userservice.service;

import com.archTech.userservice.entity.Cart;
import com.archTech.userservice.entity.User;
import com.archTech.userservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user)
    {

        //Adding cart when a user register

        HttpEntity<Cart> request = new HttpEntity<>(new Cart(user.getUserId(),user.getUserId()));

        Cart cart = restTemplate.postForObject("http://localhost:9010/carts/addCart", request, Cart.class);

        return userRepository.save(user);
    }


    public User findUserById(Long userId)
    {
        return  userRepository.findByUserId(userId);
    }

    public User findUserByEmail(String email) {return  userRepository.findByEmail(email);}


}
