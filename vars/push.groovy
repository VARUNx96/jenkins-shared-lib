def call(String image) {
                echo "🚛 📦 pushing image to docker hub...."
                withCredentials([usernamePassword(
                'credentialsId':"dockerhubcred",
                passwordVariable:"dockerhubpass",
                usernameVariable:"dockerhubuser")])
                  {
                  sh """
                  export PATH=/usr/local/bin:/opt/homebrew/bin:\$PATH
                  echo "PATH is: \$PATH"
                  
                  echo "|${dockerhubuser}|"

                  echo "🔐 Logging into Docker Hub..."
                  echo "${dockerhubpass}" | docker login -u "${dockerhubuser}" --password-stdin

                  echo "🏷️ Tagging image..."
                  docker tag ${image} "${dockerhubuser}/${image}"

                  echo "📤 Pushing image to Docker Hub..."
                  docker push "${dockerhubuser}/${image}"

                  echo "🏠 📦 image is deliverd to the hub..."
                  """
                  }
}
