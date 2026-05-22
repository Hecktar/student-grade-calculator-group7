pipeline {
    agent any

    tools {
        maven 'Maven'   // must match the name in Jenkins → Global Tool Configuration
        jdk 'JDK11'     // must match the name in Jenkins → Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.war',
                                 fingerprint: true,
                                 allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/*.xml'
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