package com.example.demospring.users;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.util.Optional;

@Component
public class UserGateway {

    private RestTemplate restTemplate;

    public UserGateway(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Optional<UserResponse> getUserById(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        try {
            UserResponse response = restTemplate.getForObject(url, UserResponse.class);
            return Optional.ofNullable(response);
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
