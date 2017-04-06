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
        mail(subject: 'test', body: 'trs', to: 'turisto@gmail.com')
      }
    }
  }
}