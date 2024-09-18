FROM maven:3.9.8-eclipse-temurin-17-alpine AS build
COPY . . 
RUN mvn clean install -DskipTests=true

FROM openjdk:17-jdk-oracle
WORKDIR /app_build
COPY --from=build /target/*.jar webservice.jar
EXPOSE 5000
ENTRYPOINT [ "java", "-jar", "/app_build/webservice.jar" ]