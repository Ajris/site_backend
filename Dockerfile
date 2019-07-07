FROM maven:3.6.1-jdk-12 as build
WORKDIR /app
COPY pom.xml /app
COPY /src /app/src
RUN mvn install

FROM openjdk:12-jdk-oracle
WORKDIR /app
COPY --from=build /app/target/site-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "site-0.0.1-SNAPSHOT.jar"]