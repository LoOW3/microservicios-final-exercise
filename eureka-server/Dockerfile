FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/eureka-server-0.0.1.jar
COPY ${JAR_FILE} app_eureka_server.jar
ENTRYPOINT ["java", "-jar", "app_eureka_server.jar"]