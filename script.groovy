def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t jason8746/my-app:1.0.0-java-multi-pipeline-amd64 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push jason8746/my-app:1.0.0-java-multi-pipeline-amd64'
    }
} 

def deployApp() {
    echo 'deploying the application by docker-compose...'
    
    // def copyDocker_composeCMD = 
    def dockerComposeCMD = 'docker compose up -d'
    sshagent(['ec2-server']) {
        sh 'scp docker-compose.yaml ec2-user@3.25.180.251:/home/ec2-user'
        // sh 'scp docker-compose.yaml ec2-user@3.25.180.251:~/'
        sh "ssh -o StrictHostkeyChecking=no ec2-user@3.25.180.251 ${dockerComposeCMD}"
    } 
}

def masterBranch(){
    BRANCH_NAME == "master"
}

return this
