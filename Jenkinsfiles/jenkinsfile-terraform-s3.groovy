pipeline {
    agent any
    stages {
        stage ('codecheckout') {
            steps{
                checkout scm
            }
        }
        stage ('Terraform') {
            steps {
                dir ('/var/lib/jenkins/workplace/s3/Terraform/s3-new/') {
                    withEnv (["Bucket_Name = ${params.Bucket_Name}"]) {
                        sh'sudo terraform init'
                        sleep(90)
                        sh'sudo terraform apply -var "Bucket_Name = ${Bucket_Name}" -auto-approve'   
                    }
                }
            }
        }
        stage ('output') {
            steps {
                echo "${Bucket_Name} has successfully created"
            }
        }
    }
}
