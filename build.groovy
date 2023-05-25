// Declarative pipeline

pipeline{
    agent any
    stages{
        stage("checkout code"){
            steps{
                println "Here im clonig the code from github"
            }
        }
        stage("Build"){
            steps{

                println "Here im building the code --mvn clean package "
            }
        }
        stage("Uploadig artifacts to S3 bucket"){
            steps{
                println "Here im adding the artifacts to S3 bucket"
            }
        }
    }
}