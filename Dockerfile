# Use an official OpenJDK image as a base image
FROM openjdk:11 AS builder

WORKDIR /app

COPY . .

RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app
# Copy the JAR file and any other necessary files
COPY --from=builder /app/build/libs/IMS-0.0.1-SNAPSHOT.jar /app/IMS-0.0.1-SNAPSHOT.jar

# Specify the default command to run when the container starts
CMD ["java", "-jar", "IMS-0.0.1-SNAPSHOT.jar"]
