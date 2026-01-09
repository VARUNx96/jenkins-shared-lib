def call(String docker_image) {
                echo "this is building the code....🧱🧱🧱"
                sh """
                  export PATH=/usr/local/bin:/opt/homebrew/bin:$PATH
                  echo "PATH is: $PATH"
                  docker --version
                  docker build -t ${docker_image} .
                """
                echo "the image is built successfully...📦📦📦"
}
