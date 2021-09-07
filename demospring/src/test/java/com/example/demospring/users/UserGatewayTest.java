package com.example.demospring.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserGatewayTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    public void getUserById() {
        Optional<UserResponse> response = userGateway.getUserById(1);

        assertTrue(response.isPresent());
        assertEquals(1, response.get().getId());
        assertEquals("Leanne Graham", response.get().getName());
    }

}