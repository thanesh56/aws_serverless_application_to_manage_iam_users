# aws_serverless_application_to_manage_iam_users_using_java_angular
# hosting_through_codepipeline. 

AWS Serverless application to Manage IAM users:- I have created a full-stack application to perform CRUD operation in IAM user, sync with Dynamodb table, and hosting is done through CodePipeline. 

<h2>Backend Serverless Application:-</h2>
- The backend code in java(spring boot)
  - https://spring.io/projects/spring-boot

- We will need to use AWS SDK to connect to the AWS account and do IAM users related operations. 
  - https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/

- The data will be stored in DynamoDB table.
  - https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-dynamodb.html 

Requirement:

- We need to create some APIs

- Sync IAM users (This will get all the IAM users from the AWS account and add them to dynamodb. Remove old users to avoid duplication.)
 
- List IAM users (This will get all the IAM users from Dynamodb and return as json)

- Show single IAM user details (This will get 1 IAM user detail for which the details requested from DynamoDB)

- Delete IAM user (This will delete the IAM user from AWS then accordingly user also deleted from DyanmoDB and do sync again)

- Create IAM user (This will create new IAM user in AWS account and do sync again)

- Before that need few configurations 
  - Dyanmodb Configuration:- Here we can configure the dynamodb mapper for that we need credentials of aws dynamodb, which can be done  
    through properties file or the secure way we can use AWS Security Manager for that we need another configuration which is a key 
    management service(KMS)
  - Which is placed inside the config package in my project



 
<h2>Frontend:</h2>

We can create frontend using preferably angular or any other technology you like. This will be deployed on S3.

https://www.techiediaries.com/angular/angular-9-8-tutorial-by-example-rest-crud-apis-http-get-requests-with-httpclient/

https://www.djamware.com/post/5d8d7fc10daa6c77eed3b2f2/angular-8-tutorial-rest-api-and-httpclient-examples


- Single Page IAM user list table. Show all IAM users. (List IAM user api will be called)

- Each User row will have 2 buttons, More, Delete

- More button will show all the user details (Will call Show single IAM user details API)

- Delete the IAM user button click calls the delete API. (Will call Show delete IAM user API)

- There will be a Create button on the page. This will open a pop asking User details. (Will call the Create IAM user API)


#Hosting
<h2>Backend</h2>:-
<h2>Frontend</h2>:-















