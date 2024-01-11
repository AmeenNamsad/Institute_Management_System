# Use an official OpenJDK image as a base image
FROM openjdk:11 AS builder

# Set the working directory inside the container
WORKDIR /app

RUN ./gradlew  bootJar

# Copy the JAR file and any other necessary files
COPY build/libs/IMS-0.0.1-SNAPSHOT.jar /app/IMS-0.0.1-SNAPSHOT.jar

# Specify the default command to run when the container starts
CMD ["java", "-jar", "IMS-0.0.1-SNAPSHOT.jar"]
