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
                    echo "===== Jenkins Environment ====="
                    echo "User:"
                    whoami

                    echo ""
                    echo "PATH:"
                    echo $PATH

                    echo ""
                    echo "Java:"
                    java -version || true

                    echo ""
                    echo "Maven location:"
                    which mvn || true

                    echo ""
                    echo "Maven:"
                    mvn -version || true
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
            echo '✅ CI Pipeline completed successfully!'
        }

        failure {
            echo '❌ CI Pipeline failed!'
        }

        always {
            echo '🏁 Jenkins pipeline finished.'
        }
    }
}
