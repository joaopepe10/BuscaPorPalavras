FROM openjdk:17-jdk-slim

WORKDIR /projeto

COPY target/desafio-sillion-1.0-SNAPSHOT.jar /projeto/desafio-sillion-1.0-SNAPSHOT.jar
COPY pom.xml /projeto

CMD ["java", "-jar", "desafio-sillion-1.0-SNAPSHOT.jar"]