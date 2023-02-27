### CD - Deploy Application from Jenkins Pipeline on EC2 Instance (automatically with docker-compose)

### Technologies used:

AWS, Jenkins, Docker, Linux, Git, Java, Maven, Docker Hub

### Project Description:

1- Install Docker and Docker Compose on AWS EC2 Instance

2- Create ssh key credentials for EC2 server on Jenkins

3- Create docker-compose.yml file that deploys our web application image

3- Configure Jenkins pipeline to deploy newly built image using Docker Compose on EC2 server

4- Improvement: Extract multiple Linux commands that are executed on remote server into a separate shell script and execute the script from Jenkinsfile

### Installation instructions:

###### Step 1: Create EC2 instance on AWS

###### Step 2: Install Docker inside the EC2 Instance

###### Step 4: Create SSH key credentials for EC2 server on Jenkins globally

![image](image/Screenshot%202023-02-26%20at%207.17.09%20pm.png)

###### Step 5: Install SSH Agent plugin on Jenkins UI

![image](image/Screenshot%202023-02-26%20at%207.17.01%20pm.png)

###### Step 6: Create Multi-pipeline for Java project and bind it to git repository and configure the credentials for the pipeline

###### Step 7: Install Docker-compose on EC2 instance

###### Step 8: Create Dockerfile, Docker-compose.yaml file and Jenkins file for Java project

![image](image/Screenshot%202023-02-26%20at%209.36.29%20pm.png)

###### Step 9: Update the Jenkins file on Deployment stage with Jenkins login EC2 server, copy docker-compose file to EC2 instance and run Java app as a container by docker-compose

![image](image/Screenshot%202023-02-26%20at%2010.27.05%20pm.png)

###### Step 10: Update the Jenkins ip and app running port to EC2 Instance security

![image](image/Screenshot%202023-02-26%20at%208.17.49%20pm.png)

![image](image/Screenshot%202023-02-26%20at%2010.27.15%20pm.png)

###### Step 11: Extract multiple Linux commands into a separate shell script for Improvement

1-Create a shell script file

![image](image/Screenshot%202023-02-27%20at%202.16.11%20pm.png)

![image](image/Screenshot%202023-02-27%20at%202.49.09%20pm.png)
![image](image/Screenshot%202023-02-27%20at%202.49.17%20pm.png)

![image](image/Screenshot%202023-02-27%20at%202.53.45%20pm.png)

![image](image/Screenshot%202023-02-27%20at%202.48.23%20pm.png)
