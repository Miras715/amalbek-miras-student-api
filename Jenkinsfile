pipeline {
    agent any

    environment {
        STUDENT = 'Amalbek Miras'
        IMAGE   = 'amalbek-miras-student-api:v1.0-amalbek-miras'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Student: ${STUDENT}"
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test --no-daemon'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE} ."
            }
        }
        stage('Verify') {
            steps {
                sh "docker image inspect ${IMAGE} --format 'Image {{.RepoTags}} created {{.Created}} size {{.Size}}'"
                echo "Image ${IMAGE} built successfully by ${STUDENT}"
            }
        }
    }

    post {
        success { echo "Pipeline SUCCESS for ${STUDENT}" }
        failure { echo "Pipeline FAILED for ${STUDENT}" }
    }
}
