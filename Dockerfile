FROM gradle:jdk12 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:12-jdk-oracle
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/site-backend.jar
ENTRYPOINT ["java", "-jar", "/app/site-backend.jar"]