def gv

pipeline {

    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description:'')
        booleanParam(name: 'execTests', defaultValue: true, description: '')
    }
    stages {

        stage("init") {

            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build") {

            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
           when {
            expression {
                params.executeTests
            }
           } 
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            input {
                message "select environment to deploy to"
                ok "done"
                parameters {
                    choice(name: 'ENV-1', choices: ['dev', 'staging', 'production'], description:'')
                    choice(name: 'ENV-2', choices: ['dev', 'staging', 'production'], description:'')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "deploy to ${ENV-1}"
                    echo "deploy to ${ENV-2}"
                }
            }
        }
    }
}