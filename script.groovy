def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t tanreaper/demo-app:1.0 .'
        sh 'docker login -u $USERNAME -p $PASSWORD'
        sh 'docker push tanreaper/demo-app:1.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this
