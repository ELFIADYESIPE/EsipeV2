     
    pipeline {
    agent any

    stages {
      
      stage ('Preparation') {
        git 'https://github.com/ELFIADYESIPE/EsipeV2'
        }
      
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'apache-maven-binary-3.5.4') {
                    sh 'mvn clean compile'
                }
            }
          steps {
                sh './gradlew check'
            }
        }

        stage ('Testing Stage') {
          
            steps {
                post {
                  always always {
                    junit '**/reports/junit/*.xml'
                    }
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                def server = Artifactory.server 'http://localhost:8080/'
                }
          steps {
            def server = Artifactory.newServer url: '192.168.4.189', username: 'guest', password: 'guest'
          }
            }
        }
    }
}
