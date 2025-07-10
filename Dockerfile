# ----------- Build-Stage: Projekt bauen mit Maven und Java 17 -----------
# Verwende Maven mit Java 17 als Build-Image
FROM maven:3.9.6-eclipse-temurin-17 AS build
# Setze das Arbeitsverzeichnis im Container
WORKDIR /app
# Kopiere die pom.xml und den Quellcode ins Build-Image
COPY pom.xml .
COPY src ./src
# Baue das Projekt (ohne Tests auszuführen)
RUN mvn clean package -DskipTests

# ----------- Laufzeit-Stage: Nur das gebaute JAR und Java 17 -----------
# Verwende ein schlankes Java 17 Laufzeit-Image
FROM eclipse-temurin:17-jre
# Setze das Arbeitsverzeichnis im Container
WORKDIR /app
# Kopiere das gebaute JAR aus dem Build-Image in das Laufzeit-Image
COPY --from=build /app/target/fundgrube-0.0.1-SNAPSHOT.jar app.jar
# Öffne Port 8080 für den Zugriff auf die Anwendung
EXPOSE 8080
# Startbefehl für die Spring Boot Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]
