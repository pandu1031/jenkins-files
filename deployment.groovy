//Declarative pipeline
pipeline{
    agent any 
    parameters {
    string( name: 'BRANCH_NAME', defaultValue: 'master', description: 'pass here deployment branch name')
    string( name: 'BUILD_NUM', defaultValue: '', description: 'here im passing deployment build number')
    string( name: 'SERVER_IP', defaultValue: '', description: 'here im passing server ip')
  }
  stages{
    stage("Copying artifacts"){
        steps{
        println " here im copying artfacts from s3 bucket"
        sh """ 
               aws s3 ls 
               aws s3 ls s3://mamuu
               aws s3 ls s3://mamuu/${BRANCH_NAME}/${BUILD_NUM}/
               aws s3 cp s3://mamuu/${BRANCH_NAME}/${BUILD_NUM}/hello-${BUILD_NUM}.war .
               whoami
        """
    }
    }
    stage("Deploying"){
        steps{
            println "here im deploying the artifacts from jenkins server to Tomcat"
            sh "ssh -i /tmp/mamu1031.pem ec2-user@${SERVER_IP} \"systemctl status tomcat\""
        }
    }

  }
}