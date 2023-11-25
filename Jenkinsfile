def gv

pipeline {

    agent any
    stages {
        stage("test") {

            steps {
                script {
                   echo "testing app"
                   echo "executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        stage("build") {
           when {
            expression {
                BRANCH_NAME == "master"
            }
           } 
            steps {
                script {
                    echo "build the app"
                }
            }
        }
        stage("deploy") {
            when {
            expression {
                BRANCH_NAME == "master"
            }
           } 
            steps {
                script {
                    echo "deploy the app"
                }
            }
        }
    }
}
