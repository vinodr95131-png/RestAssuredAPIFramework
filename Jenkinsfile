pipeline {

    agent any

    stages {

        stage('Checkout') {

            steps {
                git 'https://github.com/vinodr95131-png/RestAssuredAPIFramework.git'
            }
        }

        stage('Build & Test') {

            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish Reports') {

            steps {
                publishHTML(target: [
                        reportDir: 'reports',
                        reportFiles: 'APIReport.html',
                        reportName: 'API Automation Report'
                ])
            }
        }
    }
}