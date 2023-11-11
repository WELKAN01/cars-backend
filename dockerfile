FROM openjdk:17-jdk-alpine
COPY target/Spring-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "/demo-0.0.1-SNAPSHOT.jar"]