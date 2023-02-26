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
    echo 'deploying the application...'
    def dockerRunAppCMD = 'docker run -p 8080:8080 -d --name java-app jason8746/my-app:1.0.0-java-multi-pipeline-amd64'
    sshagent(['ec2-server']) {
        sh "ssh -o StrictHostkeyChecking=no ec2-user@3.25.180.251 ${dockerRunAppCMD}"
    } 
}

def masterBranch(){
    BRANCH_NAME == "master"
}

return this
