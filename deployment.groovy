//Declarative pipeline
pipeline{
    agent any 
    parameters {
    string( name: 'BRANCH_NAME', defaultValue: 'master', description: 'pass here deployment branch name')
    string( name: 'BUILD_NUM', defaultValue: '', description: 'here im passing deployment build number')
  }
  stages{
    stage("Copying artifacts"){
        steps{
        println " here im copying artfacts from s3 bucket"
    } 
    }
    stage("Deploying"){
        steps{
            println "here im deploying the artifacts"
        }
    }

  }
}