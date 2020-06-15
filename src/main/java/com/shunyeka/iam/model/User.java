package com.shunyeka.iam.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "iam_user_tb")
@ApiModel(value = "User",description = "IAM User Model")
public class User {

    @ApiModelProperty(notes = "Path of the IAM User")
    private String path;
    @ApiModelProperty(notes = "Name of the IAM User")
    private String userName;
    @ApiModelProperty(notes = "Id of the IAM User")
    private String userId;
    @ApiModelProperty(notes = "ARN of the IAM User")
    private String arn;
    @ApiModelProperty(notes = "Date in which  IAM User Created")
    private Date createDate;


    @DynamoDBAttribute(attributeName = "path")
    public String getPath() {
        return path;
    }

    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    @DynamoDBHashKey(attributeName = "user_id")
    public String getUserId() {
        return userId;
    }

    @DynamoDBAttribute(attributeName = "arn")
    public String getArn() {
        return arn;
    }

    @DynamoDBAttribute(attributeName = "createDate")
    public Date getCreateDate() {
        return createDate;
    }




}
