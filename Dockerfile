FROM openjdk:19-jdk-slim

WORKDIR /app

COPY . /app

FROM openjdk:19 as runtime
WORKDIR /app
ENV PORT 8080
ENV SPRING_PROFILE production
ARG JAR_FILE=/app/target*.jar
COPY --from=maven ${JAR_FILE} /app/app.jar

RUN chown -R 1000/1000 /app
USER 1000:1000

ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "-Dspring.profiles.active=${SPRING_PROFILE}", "app.jar"]
