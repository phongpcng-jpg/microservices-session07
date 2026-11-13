# Stage 1: Build the Spring Boot application
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Gradle Wrapper and project configuration
COPY gradlew ./
COPY gradle/ ./gradle/
COPY settings.gradle build.gradle ./

# Copy application source
COPY src/ ./src/

# Build the executable Spring Boot JAR inside Docker
RUN chmod +x gradlew \
    && ./gradlew clean bootJar --no-daemon \
    && JAR_FILE="$(find build/libs -maxdepth 1 -type f -name '*.jar' ! -name '*-plain.jar' -print -quit)" \
    && test -n "$JAR_FILE" \
    && cp "$JAR_FILE" /app/app.jar

# Stage 2: Run the application with a lightweight JRE
FROM eclipse-temurin:21-jre AS runtime

WORKDIR /app

COPY --from=builder /app/app.jar ./app.jar

# Run the application as a non-root user
USER 10001:10001

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "app.jar"]
