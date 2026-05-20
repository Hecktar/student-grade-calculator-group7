pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/Hecktar/student-grade-calculator-group7.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
