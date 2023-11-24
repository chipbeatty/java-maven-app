def buildApp() {
    echo 'build app'
}

def testApp() {
    echo 'test app'
}

def deployApp() {
    echo 'deploy app'
    echo "deploy version ${params.VERSION}"
}
return this