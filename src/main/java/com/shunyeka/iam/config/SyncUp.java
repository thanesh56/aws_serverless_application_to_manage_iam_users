package com.shunyeka.iam.config;

import com.shunyeka.iam.model.User;
import com.shunyeka.iam.repository.IAMUserRepository;
import com.shunyeka.iam.service.DynamoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SyncUp implements CommandLineRunner {
    @Autowired
    IAMUserRepository iamUserRepository;
    @Autowired
    DynamoDBService dynamoDBService;


    @Override
    public void run(String... args) throws Exception {
      List<User> users =  iamUserRepository.getAllUser();
        dynamoDBService.deleteAllExistingUsers(users);
        dynamoDBService.saveAllUser(users);
    }
}

