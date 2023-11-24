pipeline {

    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description:'')
        booleanParam(name: 'execTests', defaultValue: true, description: '')
    }
    stages {

        stage("build") {

            steps {
                echo 'building the app'
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
                echo "deploy version ${params.VERSION}"
            }
        }
    }
}