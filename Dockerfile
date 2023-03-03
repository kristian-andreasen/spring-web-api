FROM openjdk:19-jdk-slim
WORKDIR /app
COPY . .
RUN mkdir /app
RUN maven clean package

# Use the official OpenJDK 19 image as the base image for the runtime stage
FROM openjdk:19 as runtime

# Set the working directory to /app
WORKDIR /aoo

# Set environment variables for the application
ENV PORT 8080
ENV SPRING_PROFILE production

# Set the ARG variable for the JAR file location
ARG JAR_FILE=/app/target*.jar

# Copy the built JAR file to the container's /app directory
COPY --from=maven ${JAR_FILE} /app/app.jar

# Set the user and group ownership for the /app directory
RUN chown -R 1000/1000 /app
USER 1000:1000

# Set the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "-Dspring.profiles.active=${SPRING_PROFILE}", "app.jar"]
