# aws_serverless_application_to_manage_iam_users_using_java_angular
AWS Serverless application to Manage IAM users:- I have created a full-stack application to perform CRUD operation in IAM user, sync with Dynamodb table, and hosting is done through CodePipeline. 

Backend Serverless Application:-
- The backend code in java(springboot)

- We will need to use AWS SDK to connect to AWS account and do IAM users related operations. 

- The data will be stored in DynamoDB table. 

Requirement:

- We need to Creadted some APIs

- Sync IAM users (This will get all the IAM users from the AWS account and add them to dynamodb. Remove old users to avoid duplication.)
 
- List IAM users (This will get all the IAM users from Dynamodb and return as json)

- Show single IAM user details (This will get 1 IAM user detail for which the details requested from DynamoDB)

- Delete IAM user (This will delete the IAM user from AWS then accordingly user also deleted from DyanmoDB and do sync again)

- Create IAM user (This will create new IAM user in AWS account and do sync again)

 
Frontend:

We can create frontend using preferably angular or any other technology you like. This will be deployed on S3.

https://www.techiediaries.com/angular/angular-9-8-tutorial-by-example-rest-crud-apis-http-get-requests-with-httpclient/

https://www.djamware.com/post/5d8d7fc10daa6c77eed3b2f2/angular-8-tutorial-rest-api-and-httpclient-examples

- Single Page IAM user list table. Show all IAM users. (List IAM user api will be called)

- Each User row will have 2 buttons, More, Delete

- More button will show all the user details (Will call Show single IAM user details API)

- Delete IAM user button click calls the delete api. (Will call Show delete IAM user API)

- There will be a Create button on the page. This will open a popup asking User details. (Will call the Create IAM user API)












