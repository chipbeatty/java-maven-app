pipeline {

    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }
    stages {

        stage("build") {

            steps {
                echo 'building the app'
                echo "building version ${NEW_VERSION}"
            }
        }
        stage("test") {
            
            steps {
                echo 'test the app'
            }
        }
        stage("deploy") {

            steps {
                echo 'deploy the app'
                withCredentials([
                    usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
                ]) {
                    sh "test script ${USER} ${PWD}"
                }
            }
        }
    }
}