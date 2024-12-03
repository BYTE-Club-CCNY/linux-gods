# Stage 1: Build the application
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy necessary files
COPY . ./

# Make mvnw executable
RUN chmod +x mvnw 

# Build the application
RUN ./mvnw clean package

# Stage 2: Create a runtime image
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/byteserver-0.1.jar /app/byteserver-0.1.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/byteserver-0.1.jar"]