#!/bin/bash
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip

aws configure set aws_access_key_id         value
aws configure set aws_secret_access_key     value
aws configure set default.region            value


wget https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_linux-x64_bin.tar.gz
tar -xvzf openjdk-11+28_linux-x64_bin.tar.gz
export JAVA_HOME=/home/ec2-user/jdk-11
export PATH=$PATH:$JAVA_HOME/bin

java -jar  -Dspring.profiles.active=dev /home/ec2-user/iam-0.0.6-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &
