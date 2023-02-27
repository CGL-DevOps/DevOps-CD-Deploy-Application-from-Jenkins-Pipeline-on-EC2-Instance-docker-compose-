def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ${IMAGE_NAME} .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push ${IMAGE_NAME}'
    }
} 

def deployApp() {
    echo 'deploying the application by docker-compose...'
    
    // def copyDocker_composeCMD = 
    // def dockerComposeCMD = 'docker-compose up -d'
    def runServerCmd = "bash ./server-cmd.sh" 
    def ec2Server = 'ec2-user@3.25.180.251'
    def destinationOnEC2 = '/home/ec2-user'
    sshagent(['ec2-server']) {
        sh 'scp docker-compose.yaml $ec2Server:$destinationOnEC2'
        // sh 'scp docker-compose.yaml ec2-user@3.25.180.251:~/'
        sh 'scp server-cmd.sh $ec2Server:$destinationOnEC2'
        sh "ssh -o StrictHostkeyChecking=no $ec2Server ${runServerCmd}"
    } 
}

def masterBranch(){
    BRANCH_NAME == "master"
}

return this
