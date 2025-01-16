/*
    Note:

    Windows users use "bat" instead of "sh"
    For ex: bat 'docker build -t=vlasovandrei/automation_selenium .'

    Do not use "vlasovandrei" to push. Use your dockerhub account
*/
pipeline{

    agent any

    stages{

        stage('Build Jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image'){
            steps{
                bat 'docker build -t=vlasovandrei/automation_selenium .'
            }
        }

        stage('Push Image'){
            environment{
                // assuming you have stored the credentials with this name
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps{
                // There might be a warning.
                bat 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                bat 'docker push vlasovandrei/automation_selenium'
            }
        }

    }

    post {
        always {
            bat 'docker logout'
        }
    }

}