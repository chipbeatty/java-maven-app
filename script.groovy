def buildJar() {
    echo 'build app'
    sh 'mvn package'
}

def buildImage() {
    echo 'build app'
    echo "build the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t cbblazor/demo-app:jma-2.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push cbblazor/demo-app:jma-2.0'
                    }
}

def testApp() {
    echo 'test app'
}

def deployApp() {
    echo 'deploy app'
}
return this