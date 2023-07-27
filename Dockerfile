FROM openjdk:17-jdk-slim

WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "app.jar"]