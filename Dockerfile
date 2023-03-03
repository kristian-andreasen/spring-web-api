FROM maven:3-openjdk-17 AS maven
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /app/src/
RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim as runtime
WORKDIR /app
ENV PORT 8080
ENV SPRING_PROFILE production
COPY --from=maven /app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "-Dspring.profiles.active=${SPRING_PROFILE}", "app.jar"]
