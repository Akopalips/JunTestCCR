FROM openjdk:11

ARG JAR_FILE=target/*.jar
ARG _JAVA_OPTIONS=-Dlogging.level.root=INFO

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]