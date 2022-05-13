package io.dpaul.spring.actuator.repository;

import io.dpaul.spring.actuator.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> getAllUser() {

        return Arrays.asList(new User(1, "d", false)
                , new User(2, "r", true)
                , new User(3, "t", true));

    }
}
