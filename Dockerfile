# Dockerfile para Spring Boot
FROM openjdk:19
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
