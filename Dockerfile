# Imagen alternativa a Jib (mismo resultado — Jib es el camino del CI).
# Sirve también para generar el baseline :0.9.0 con el código de listing.
FROM eclipse-temurin:21-jre-alpine
COPY target/test-back-*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
