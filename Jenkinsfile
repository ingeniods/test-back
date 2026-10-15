// CI test-back — build + tests + imagen ghcr.io por Jib (tag = version pom)
// + sonar (sonarqube local en la red docker).
// El tag de imagen DEBE coincidir con ${project.version}: resolveVersion
// devuelve el pom y verifyDeployment casa la versión del pod por el tag.
pipeline {
  agent any
  stages {
    stage('verify') {
      steps { sh './mvnw -B verify' }
      post { always { junit 'target/surefire-reports/*.xml' } }
    }
    stage('image') {
      when { anyOf { branch 'develop'; branch 'master' } }
      steps {
        script {
          def ver = sh(returnStdout: true, script:
            "./mvnw -q help:evaluate -Dexpression=project.version -DforceStdout | tail -1").trim()
          currentBuild.displayName = ver
          withCredentials([string(credentialsId: 'ghcr-token', variable: 'GHCR_PAT')]) {
            withEnv(["GHCR_USER=ingeniods", "IMG=ghcr.io/ingeniods/test-back:${ver}"]) {
              sh '''
                # el daemon fija la plataforma: aarch64→arm64, x86_64→amd64
                ARCH=$(docker info -f '{{.Architecture}}' | sed 's/aarch64/arm64/;s/x86_64/amd64/')
                ./mvnw -B jib:dockerBuild -Djib.to.image="$IMG" -Djib.arch="$ARCH"
                # carga al nodo kind (equivalente a `kind load`, sin el binario)
                docker save "$IMG" | docker exec -i agd-control-plane ctr -n k8s.io images import -
                # push a GHCR solo si hay PAT configurado
                if [ -n "$GHCR_PAT" ]; then
                  echo "$GHCR_PAT" | docker login ghcr.io -u "$GHCR_USER" --password-stdin
                  docker push "$IMG"
                fi
              '''
            }
          }
        }
      }
    }
    stage('sonar') {
      steps {
        withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
          sh './mvnw -B sonar:sonar \
                -Dsonar.host.url=http://sonarqube:9000 \
                -Dsonar.login=$SONAR_TOKEN \
                -Dsonar.projectKey=test-back'
        }
      }
    }
  }
}
