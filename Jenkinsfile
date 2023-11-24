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
                    choice(name: 'ONE', choices: ['dev', 'staging', 'production'], description:'')
                    choice(name: 'TWO', choices: ['dev', 'staging', 'production'], description:'')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "deploy to ${ONE}"
                    echo "deploy to ${TWO}"
                }
            }
        }
    }
}