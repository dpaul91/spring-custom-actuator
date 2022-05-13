package io.dpaul.spring.actuator.controller;

import io.dpaul.spring.actuator.model.User;
import io.dpaul.spring.actuator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InfoController implements InfoContributor{
    @Autowired
    UserRepository userRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userDetails = new HashMap<>();
        List<User> users = userRepository.getAllUser();
        userDetails.put("active",users.stream().filter(u -> u.isActive()).count());
        userDetails.put("inactive",users.stream().filter(u -> !u.isActive()).count());
        builder.withDetail("userDetails",userDetails);

    }
}
