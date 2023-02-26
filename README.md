### CD - Deploy Application from Jenkins Pipeline to EC2 Instance (automatically with docker)

### Technologies used:

AWS, Jenkins, Docker, Linux, Git, Java, Maven, Docker Hub

### Project Description:

1- Prepare AWS EC2 Instance for deployment (Install Docker)

2- Create ssh key credentials for EC2 server on Jenkins

3- Extend the previous CI pipeline with deploy step to ssh into the remote EC2 instance and deploy newly built image from Jenkins server

4- Configure security group on EC2 Instance to allow access to our web application

### Installation instructions:

###### Step 1: Create EC2 instance on AWS

###### Step 2: Install Docker inside the EC2 Instance

###### Step 4: Create SSH key credentials for EC2 server on Jenkins globally

![image](image/Screenshot%202023-02-26%20at%207.17.09%20pm.png)

###### Step 5: Install SSH Agent plugin on Jenkins UI

![image](image/Screenshot%202023-02-26%20at%207.17.01%20pm.png)

###### Step 6: Create Multi-pipeline for Java project and bind it to git repository and configure the credentials for the pipeline

###### Step 8: Create Dockerfile, Docker-compose.yaml file and Jenkins file for Java project

![image](image/Screenshot%202023-02-26%20at%209.36.29%20pm.png)

###### Step 10: Update the Jenkins file on Deployment stage with Jenkins login EC2 server, copy docker-compose file to EC2 instance and run Java app as a container by docker-compose

![image](image/Screenshot%202023-02-26%20at%2010.27.05%20pm.png)

###### Step 11: Update the Jenkins ip and app running port to EC2 Instance security

![image](image/Screenshot%202023-02-26%20at%208.17.49%20pm.png)

![image](image/Screenshot%202023-02-26%20at%2010.27.15%20pm.png)
