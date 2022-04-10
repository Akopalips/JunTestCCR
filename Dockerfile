FROM azul/zulu-openjdk-alpine:11.0.12-11.50.19 as mvn-build
WORKDIR /src
COPY . .
RUN ./mvnw -v
RUN ./mvnw package

FROM azul/zulu-openjdk-alpine:11.0.12-11.50.19-jre-headless
COPY --from=mvn-build /src/target/SpringProj-0.0.1-SNAPSHOT.jar /app/SpringProj.jar
EXPOSE 8080
CMD java -Xmx2g -jar /app/SpringProj.jar
