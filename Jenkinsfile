pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn install'
      }
    }
    stage('error') {
      steps {
        echo 'hi'
      }
    }
  }
}