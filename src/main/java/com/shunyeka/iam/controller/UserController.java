package com.shunyeka.iam.controller;

import com.shunyeka.iam.constant.UserConstant;
import com.shunyeka.iam.reponse.ServerResponse;
import com.shunyeka.iam.service.DynamoDBService;
import com.shunyeka.iam.service.IAMUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = UserConstant.USER)
@Api(value = "User Controller REST Endpoint",description="Shows The IAM User Info")
public class UserController {

    private final DynamoDBService dynamoDBService;
    private final IAMUserService iamUserService;

    public UserController(DynamoDBService dynamoDBService, IAMUserService iamUserService) {
        this.dynamoDBService = dynamoDBService;
        this.iamUserService = iamUserService;
    }



    /**
     * Getting User By Id
     * @param take User Id as parameter
     * @return User
     */
    @ApiOperation(value = "Getting User By Id From DynamoDB.")
    @GetMapping(value = UserConstant.GET_USER_BY_ID_URL)
    public ResponseEntity<ServerResponse> getUserById(@PathVariable String userId) {
        log.debug("Getting User By Id.");
        ResponseEntity<ServerResponse> serverResponseEntity;
        serverResponseEntity = new ResponseEntity(new ServerResponse(HttpStatus.OK.value() + "", "Gotted user of UserId: " + userId + "", dynamoDBService.getUserById(userId), HttpStatus.OK.name()), HttpStatus.OK);
        return serverResponseEntity;
    }


    /**
     * @return list of users
     */
    @ApiOperation(value = "Getting All Users From DynamoDB.")
    @GetMapping(value = UserConstant.GET_ALL_USERS_URL)
    public ResponseEntity<ServerResponse> getAllUsers() {
        log.debug("Getting List User");
        ResponseEntity<ServerResponse> serverResponseEntity;
        serverResponseEntity = new ResponseEntity(new ServerResponse(HttpStatus.OK.value() + "", "Getted All Users", dynamoDBService.getAllUser(), HttpStatus.OK.name()), HttpStatus.OK);
        return serverResponseEntity;
    }



    /**
     *
     * @param This method take user as parameter for delete that user
     * @return success message as a 204 noContent status with exit code 1
     */
    @ApiOperation(value = "Deleting User From AWS.")
    @DeleteMapping(value = UserConstant.DELETE_USER_URL)
    public ResponseEntity<?> deleteUser(@PathVariable String userName) {
        log.debug("Deleting User ");
        iamUserService.deleteUser(userName);
        ResponseEntity<ServerResponse> serverResponseEntity;
        serverResponseEntity = new ResponseEntity(new ServerResponse(HttpStatus.OK.value()+"","User "+userName+" Successfully Deleted  ",null,HttpStatus.OK.name()),HttpStatus.OK);
        return serverResponseEntity;
    }


    /**
     *
     * @param This method take new user as parameter to store it
     * @return return that new stored user
     */
    @ApiOperation(value = "Creating New User In AWS.")
    @PostMapping(value = UserConstant.IAMUSER_URL)
    public ResponseEntity<ServerResponse> createIamUser(@PathVariable String userName){
        log.debug("Saving User.");
        ResponseEntity<ServerResponse> serverResponseEntity;
        serverResponseEntity = new ResponseEntity(new ServerResponse(HttpStatus.OK.value() + "", " User Created", iamUserService.createUser(userName), HttpStatus.OK.name()), HttpStatus.OK);
        return serverResponseEntity;
    }

}