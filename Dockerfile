FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/Poke-app-0.0.1.jar
COPY ${JAR_FILE} poke_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "poke_app.jar"]