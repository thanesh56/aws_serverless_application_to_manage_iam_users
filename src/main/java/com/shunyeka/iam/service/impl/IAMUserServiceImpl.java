package com.shunyeka.iam.service.impl;

import com.shunyeka.iam.model.User;
import com.shunyeka.iam.repository.DynamoDBRepository;
import com.shunyeka.iam.repository.IAMUserRepository;
import com.shunyeka.iam.service.IAMUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAMUserServiceImpl implements IAMUserService {

    private final IAMUserRepository iamUserRepository;
    private final DynamoDBRepository dynamoDBRepository;

    public IAMUserServiceImpl(IAMUserRepository iamUserRepository, DynamoDBRepository dynamoDBRepository) {
        this.iamUserRepository = iamUserRepository;
        this.dynamoDBRepository = dynamoDBRepository;
    }


    @Override
    public User createUser(String userName) {
        User newUser = iamUserRepository.createUser(userName);
        dynamoDBRepository.save(newUser);
        return newUser;
    }

    @Override
    public void deleteUser(String userName) {
        User user = getUser(userName);
        if( iamUserRepository.deleteUser(userName)){
            dynamoDBRepository.delete(user);
        }
    }

    @Override
    public User getUser(String userName) {
        return iamUserRepository.getUser(userName);
    }


}
