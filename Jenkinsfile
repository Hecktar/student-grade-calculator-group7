pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
<<<<<<< Updated upstream
                sh 'mvn clean package -DskipTests'
=======
                bat '"C:\\Program Files\\Maven\\apache-maven-3.9.15\\bin\\mvn.cmd"  clean package'
>>>>>>> Stashed changes
            }
        }

        stage('Test') {
            steps {
<<<<<<< Updated upstream
                sh 'mvn test'
=======
                bat 'C:\\Program Files\\Maven\\apache-maven-3.9.15\\bin\\mvn.cmd"  test'
>>>>>>> Stashed changes
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true, allowEmptyArchive: false
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check build and test logs.'
        }
    }
}
