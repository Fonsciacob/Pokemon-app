FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/Poke-app-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]