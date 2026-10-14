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
              sh './mvnw -B jib:build -Djib.to.image=$IMG'
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
