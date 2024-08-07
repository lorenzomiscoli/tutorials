FROM maven:3.9.4-amazoncorretto-17-debian AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build app/target/docker-spring-sql-server.jar docker-spring-sql-server.jar
CMD ["java", "-jar", "docker-spring-sql-server.jar"]