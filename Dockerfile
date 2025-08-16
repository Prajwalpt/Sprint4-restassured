# Use Maven 3.9.10 with Eclipse Temurin JDK 20
FROM maven:3.9.10-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy project files into the container
COPY . .

# Download dependencies first (better caching)
RUN mvn dependency:go-offline

# Run tests when container starts
CMD ["mvn", "test"]