pipeline{
    agent any

    stages{
        stage("cloning the code"){
            steps{
                println "I'm cloning the code frim git hub repo"

            }
        }
        stage("build "){
            steps{
                println "im executing the code --mvn clean package"
            
            }
        }
        stage("uploading artifacts"){
            steps{
                println "im uploading the artifacts to s3 bucket"
            }
        }
        stage("deploy"){
            steps{
                println "im deploying the code to tomcat location"
            }
        }

    }
}