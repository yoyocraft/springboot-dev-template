# Base image
FROM maven:3.8.1-jdk-8-slim AS builder

# Copy local code to container
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact
RUN mvn package -DskipTests

# Run the web service on container startup
CMD ["java", "-jar", "/app/target/spring-dev-template-1.0.0-SNAPSHOT", "--spring.profiles.active=production"]