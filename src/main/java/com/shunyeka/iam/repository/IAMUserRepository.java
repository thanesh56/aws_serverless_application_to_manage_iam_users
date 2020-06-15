package com.shunyeka.iam.repository;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.model.*;
import com.shunyeka.iam.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IAMUserRepository {
    @Autowired
    AmazonIdentityManagement amazonIdentityManagement;


    public User createUser(String userName){
        CreateUserRequest request = new CreateUserRequest().withUserName(userName);
        CreateUserResult response = amazonIdentityManagement.createUser(request);
        User user  = new User();
        user.setUserId(response.getUser().getUserId());
        user.setUserName(response.getUser().getUserName());
        user.setArn(response.getUser().getArn());
        user.setCreateDate(response.getUser().getCreateDate());
       return user;
    }


    public User getUser(String userName){
        GetUserRequest getUserRequest = new GetUserRequest().withUserName(userName);
        GetUserResult response = amazonIdentityManagement.getUser(getUserRequest);
        User user  = new User();
        user.setUserId(response.getUser().getUserId());
        user.setUserName(response.getUser().getUserName());
        user.setArn(response.getUser().getArn());
        user.setCreateDate(response.getUser().getCreateDate());
        return user;

    }


    public List<User> getAllUser() {
        ListUsersRequest request = new ListUsersRequest();
        ListUsersResult response = amazonIdentityManagement.listUsers(request);
        List<com.amazonaws.services.identitymanagement.model.User> listUsers = response.getUsers();

        List<User> newUsers = new ArrayList<>();
        User user;
        for(com.amazonaws.services.identitymanagement.model.User tempUser:listUsers){
            user  = new User();
            user.setUserId(tempUser.getUserId());
            user.setUserName(tempUser.getUserName());
            user.setArn(tempUser.getArn());
            user.setCreateDate(tempUser.getCreateDate());
            newUsers.add(user);
        }
        return newUsers;
    }

    public boolean deleteUser(String userName){
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest().withUserName(userName);
        return amazonIdentityManagement.deleteUser(deleteUserRequest) != null;

    }


}
