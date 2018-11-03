node{
  stage('SCM Checkout'){
  git 'https://github.com/ELFIADYESIPE/EsipeV2'
  }
  stage('Compile-Package'){
    //bat 'mvn verify'
  def mvnHome = tool name: 'apache-maven-binary-3.5.4', type: 'maven'
  bat (/"$(mvnHome)/bin/mvn package")
  }
}
