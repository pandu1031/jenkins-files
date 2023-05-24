pipeline{
    agent any

    stages{
        stage("clone code"){
            steps{
                println "Here I'm cloning the code frim git hub repo"

            }
        }
        stage("build "){
            steps{
                println "Here im executing the code --mvn clean package"
            
            }
        }
        stage("upload artifacts to s3 bucket"){
            steps{
                println "Hereim uploading the artifacts to s3 bucket"
            }
        }
        stage("deployment"){
            steps{
                println "Here im deploying the code to tomcat location"
            }
        }

    }
}