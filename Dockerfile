FROM gradle:7.2.0-jdk11 as Build
WORKDIR /app
COPY . /app/
RUN ["gradle", "build"]

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY --from=Build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]