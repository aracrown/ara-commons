pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        build 'test'
      }
    }
    stage('') {
      steps {
        mail(subject: 'test', body: 'trs', to: 'turisto@gmail.com')
      }
    }
  }
}