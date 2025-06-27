# Project165


📚 Fundgrube – Schulprojekt
Ein Schulprojekt im Rahmen der Erwachsenenbildung EFZ an der WISS. Die Applikation ist eine Fundgrube zum Sammeln, Speichern und Verwalten von verlorenen Gegegnstände.

✅ Funktionen
🔍 Artikel auflisten (GET)

➕ Neuer Artikel hinzufügen (POST)

📝 Vorhandene Artikel bearbeiten (PUT)

🗑️ Artikel löschen (DELETE)

💾 Daten werden in einer MongoDB gespeichert

🔗 REST API mit Spring Boot

🛠️ Tech-Stack
Komponente	Beschreibung
Java	-> Hauptprogrammiersprache
Spring Boot	->	Backend-Framework & Webservice
MongoDB	->	NoSQL Datenbank
Maven/Gradle	->	Build Tool
REST	->	API-Architektur zur Kommunikation
Postman	->	Zum Testen der Schnittstellen

🚀 Projekt starten
🔧 Voraussetzungen
Java 17+

Maven (oder Gradle)

MongoDB lokal installiert oder MongoDB Atlas Zugang

IDE wie IntelliJ oder Eclipse

⚙️ Projekt ausführen

# Repository klonen
git clone https://github.com/dein-user/fundgrube.git
cd fundgrube

# Spring Boot starten (z. B. über IDE oder CLI)
./mvnw spring-boot:run


🌐 API Endpunkte
Methode	Endpoint	Beschreibung
GET	/funds	Liste aller Fundstücke
GET	/funds/{id}	Ein Fundstück anzeigen
POST	/funds	Neues Fundstück erstellen
PUT	/funds/{id}	Fundstück aktualisieren
DELETE	/funds/{id}	Fundstück löschen

🧪 Beispiel JSON (für POST/PUT)

{
  "title": "Java Grundlagen",
  "description": "Ein gutes Java-Tutorial",
  "url": "https://java-tutorial.de",
  "category": "Tutorial"
}


📁 Projektstruktur (optional)

fundgrube/
├── src/
│   └── main/
│       ├── java/
│       │   └── ch/wiss/fundgrube/
│       │       ├── controller/
│       │       ├── model/
│       │       └── repository/
│       └── resources/
│           └── application.properties
├── README.md
├── pom.xml

👥 Team
Dusan – Backend 
Carmine – Datenbank
? – API & Test
Natalia – README 
Anina – Dokumentation

📌 Hinweise
Das Projekt ist Teil eines schulischen Lernprojekts und nicht für den produktiven Einsatz gedacht.
