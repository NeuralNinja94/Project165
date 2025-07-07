# Image mit Java 17
FROM openjdk:17-jdk-slim

# Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere pom.xml und src/
COPY pom.xml .
COPY src ./src

# Abhängigkeiten bauen (Spring-Projekt)
RUN apt-get update && apt-get install -y maven \
    && mvn -B package -DskipTests

# Port freigeben
EXPOSE 8080

# Startbefehl
CMD ["java", "-jar", "target/fundgrube-0.0.1-SNAPSHOT.jar"]
