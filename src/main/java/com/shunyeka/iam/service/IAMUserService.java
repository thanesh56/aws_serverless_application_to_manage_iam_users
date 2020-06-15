package com.shunyeka.iam.service;

import com.shunyeka.iam.model.User;


public interface IAMUserService {
    User createUser(String  userName);
    void deleteUser(String userName);
    User getUser(String userName);
}
