package com.shunyeka.iam.service;

import com.shunyeka.iam.model.User;

import java.util.List;

public interface DynamoDBService {


    List<User> getAllUser();

    User getUserById(String userId);

    void addUser(User newUser);

    void saveAllUser(List<User> newUser);

    void deleteUser(User user);


    void deleteAllExistingUsers(List<User> users);
}
