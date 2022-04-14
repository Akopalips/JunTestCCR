FROM openjdk:11
ARG JAR_FILE=target/*.jar
ARG SPRING_DATASOURCE_URL="postgresql://springdb:5432/springdb"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]