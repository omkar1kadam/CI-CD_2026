pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Environment Check') {
            steps {
                sh '''
                    echo "======================================"
                    echo "        JENKINS ENVIRONMENT"
                    echo "======================================"

                    echo ""
                    echo "User:"
                    whoami

                    echo ""
                    echo "PATH:"
                    echo "$PATH"

                    echo ""
                    echo "Java:"
                    java -version

                    echo ""
                    echo "Maven:"
                    if command -v mvn >/dev/null 2>&1; then
                        mvn -version
                    else
                        echo "Maven NOT FOUND in Jenkins PATH"
                    fi

                    echo ""
                    echo "======================================"
                '''
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Run Application') {
            steps {
                sh 'mvn exec:java -Dexec.mainClass=com.omkar1kadam.primes.Main'
            }
        }
    }

    post {
        success {
            echo 'CI Pipeline completed successfully!'
        }

        failure {
            echo 'CI Pipeline failed!'
        }

        always {
            echo 'Jenkins pipeline finished.'
        }
    }
}