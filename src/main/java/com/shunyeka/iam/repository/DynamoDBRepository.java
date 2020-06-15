package com.shunyeka.iam.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.shunyeka.iam.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DynamoDBRepository {
    private final DynamoDBMapper mapper;


    public DynamoDBRepository(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }



    public void save(User user) {
        mapper.save(user);
    }


    public void saveAll(List<User> users) {

        mapper.batchSave(users);
    }


    public void delete(User user) { mapper.delete(user); }


    public void deleteAll(List<User> users){
        mapper.batchDelete(users);
    }


    public User findById(String id) { return mapper.load(User.class,id); }


    public List<User> findAll(){
        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":val1", new AttributeValue().withS(" "));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("user_id <> :val1").withExpressionAttributeValues(eav);

        return mapper.scan(User.class, scanExpression);

    }





}
