FROM maven:3.9.4-amazoncorretto-17-debian AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn install

FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build app/target/docker-java-0.0.1-SNAPSHOT.jar docker-java.jar
CMD ["java", "-jar", "docker-java.jar"]