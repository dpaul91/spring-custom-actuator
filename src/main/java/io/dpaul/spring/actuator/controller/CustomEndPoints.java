package io.dpaul.spring.actuator.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="user-notes")
public class CustomEndPoints {

    private Map<String,String> userInfo = new HashMap<>();

    @PostConstruct
    public void fillDetails(){
        userInfo.put("details","it has 3 users");
        userInfo.put("count","2 active 1 inactive");
    }

    @ReadOperation
    public Map<String,String> getUserInfo(){
        return userInfo;
    }

    @ReadOperation
    public String getUserSpecificInfo(@Selector String key){
        return null==userInfo.get(key)? "not found" :userInfo.get(key) ;
    }

}
