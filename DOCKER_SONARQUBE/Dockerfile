FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/DOCKER_SONARQUBE-*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
