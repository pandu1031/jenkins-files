// Declarative pipeline

pipeline{
    agent any
    environment {
        BRANCH = "${BRANCH_NAME}"
    }
    stages{
        stage("checkout code"){
            steps{
                println "Here im clonnig the code from github"
                 // checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/pandu1031/boxfuse-sample-java-war-hello.git']]])
                //sh "ls -lart ./*"
                git branch: "${BRANCH_NAME}",
                url:'https://github.com/pandu1031/boxfuse-sample-java-war-hello.git'
            }
        }
        stage("Build"){
            steps{

                println "Here im building the code  "
                sh "mvn clean package"
                //sh " ls -l target/"
            }
        }
        stage("Uploadig artifacts to s3 bucket"){
            steps{
                println "Here im adding the artifacts to s3 bucket"
                sh "echo $BUILD_NUMBER"
                sh "aws s3 cp target/hello-${BUILD_NUMBER}.war s3://mamuu/master/${BUILD_NUMBER}/"
            }
        }
    }
}