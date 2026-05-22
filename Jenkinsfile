pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat '"C:\\Program Files\\Maven\\apache-maven-3.9.15\\bin\\mvn.cmd" clean package'
            }
        }

        stage('Test') {
            steps {
                bat '"C:\\Program Files\\Maven\\apache-maven-3.9.15\\bin\\mvn.cmd" test'
            }

            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true, allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution finished.'
        }

        success {
            echo 'Pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check build and test logs.'
        }
    }
}