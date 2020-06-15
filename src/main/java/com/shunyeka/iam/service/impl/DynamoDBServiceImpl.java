package com.shunyeka.iam.service.impl;

import com.shunyeka.iam.model.User;
import com.shunyeka.iam.repository.DynamoDBRepository;
import com.shunyeka.iam.service.DynamoDBService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamoDBServiceImpl implements DynamoDBService {

    private final DynamoDBRepository dynamoDBRepository;
    public DynamoDBServiceImpl(DynamoDBRepository dynamoDBRepository) {
        this.dynamoDBRepository = dynamoDBRepository;
    }



    @Override
    public List<User> getAllUser() {
        return dynamoDBRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return dynamoDBRepository.findById(userId);
    }

    @Override
    public void addUser(User newUser) {
        dynamoDBRepository.save(newUser);

    }

    @Override
    public void saveAllUser(List<User> newUser) {
        dynamoDBRepository.saveAll(newUser);
    }

    @Override
    public void deleteUser(User user) {
        dynamoDBRepository.delete(user);
        addUser(user);
    }

    @Override
    public void deleteAllExistingUsers(List<User> users) {
        dynamoDBRepository.deleteAll(users);
    }
}
