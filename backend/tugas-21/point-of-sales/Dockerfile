# Gunakan image JDK 17
FROM openjdk:17-jdk-slim

# Set direktori kerja di dalam container
WORKDIR /app

# Salin file JAR hasil build ke dalam container
COPY target/*.jar app.jar

# Jalankan aplikasi Spring Boot
CMD ["java", "-jar", "app.jar"]
