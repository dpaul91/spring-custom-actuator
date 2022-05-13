package io.dpaul.spring.actuator.controller;

import io.dpaul.spring.actuator.model.User;
import io.dpaul.spring.actuator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<User> getAllUser() {
        return userRepository.getAllUser();
    }

}
