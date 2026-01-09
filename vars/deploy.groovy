def call() {
                echo "this is deploying the code "
                sh """
                 export PATH=/usr/local/bin:/opt/homebrew/bin:\$PATH
                 echo "PATH is: \$PATH"
                 docker compose up -d
                """
}
