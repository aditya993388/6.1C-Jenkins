pipeline {
    agent any
    
    stages {
        stage('Fetch Source Code') {
            steps {
                echo "Retrieving the source code from the specified directory path."
                echo "Ensuring the necessary dependencies are in place."
            }
        }
        
        stage('Unit and Integration Tests') {
            steps {
                echo "Executing unit tests."
                echo "Performing integration tests."
            }
        }
        
        stage('Code Quality Check') {
            steps {
                echo "Analyzing the code quality using a code analysis tool."
            }
        }
        
        stage('Security Check') {
            steps {
                echo "Scanning for security vulnerabilities."
            }
        }
        
        stage('Integration Tests on Staging Environment') {
            steps {
                echo "Running integration tests on the staging environment."
            }
        }
        
        stage('Deploy to Production') {
            steps {
                echo "Deploying the code to the production environment."
            }
        }
    }
    
    post {
        success {
            emailext attachLog: true,
            compressLog: true,
            to: 'yourfriend@example.com',
            body: 'The build was successful. Log is available at $JENKINS_HOME/jobs/$JOB_NAME/builds/$BUILD_NUMBER/log',
            subject: 'Successful Deployment - Jenkins'
        }
        failure {
            emailext attachLog: true,
            compressLog: true,
            to: 'aditya@pratap.com',
            body: 'The build has failed. Log is available at $JENKINS_HOME/jobs/$JOB_NAME/builds/$BUILD_NUMBER/log',
            subject: 'Failed Deployment - Jenkins'
        }
    }
}
