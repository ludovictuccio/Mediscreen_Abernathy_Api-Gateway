FROM maven:3.6-jdk-11 AS build  
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean package  -Dmaven.test.skip=true

FROM openjdk:11
WORKDIR /app
EXPOSE 8080
COPY --from=build /build/target/apigateway-0.0.1-SNAPSHOT.jar  /app/

ENTRYPOINT ["java","-jar","apigateway-0.0.1-SNAPSHOT.jar"]