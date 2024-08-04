pipeline {
    agent any
    tools {
        maven 'maven-3.9.8'
    }
    stages {
        stage("build") {
            steps {
                echo 'building package for maven'
                sh ''
            }
        }
        stage("image") {
            steps{
                echo "building docker image for demo app...."
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                    sh 'docker build -t tanreaper/demo-app:2.0 .'
                    sh 'docker login -u $USERNAME -p $PASSWORD'
                    sh 'docker push tanreaper/demo-app:2.0'
                }

            }
        }
        stage("deploy") {
            steps{
                echo "deploying to GKE"
            }
        }
    }
}