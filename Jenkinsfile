node{
  stage('SCM Checkout'){
  git 'https://github.com/ELFIADYESIPE/EsipeV2'
  }
  stage('Compile-Package'){
  def mvnHome = tool name: 'apache-maven-binary-3.5.4', type: 'maven'
  sh "$(mvnHome)/bin/mvn package"
  }
}
