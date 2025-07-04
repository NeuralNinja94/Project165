# Project165


📚 Fundgrube – Schulprojekt
Ist eine Webanwendung zur Verwaltung von verlorenen Gegenständen. Die Anwendung basiert auf einem modernen Java-Backend mit MongoDB-Datenbankanbindung.


# ✅ Funktionen

🔍 Fundstücke anzeigen (`GET /funds`)

➕ Neues Fundstück erfassen (`POST /funds`)

📝 Fundstück bearbeiten (`PUT /funds/{id}`)

🗑️ Fundstück löschen (`DELETE /funds/{id}`)


# 💾 Daten werden in einer MongoDB gespeichert


# 🔗 REST API mit Spring Boot


# 🛠️ Tech-Stack


Komponente	      Beschreibung


Java 17+      ->  Hauptprogrammiersprache

Spring Boot	  ->	Backend-Framework & Webservice

MongoDB	      ->	NoSQL Datenbank

Maven	        ->	Build Tool

Postman	      ->	Zum Testen der REST-API



# 🚀 Projekt starten


# 🔧 Voraussetzungen

Java 17+

Maven

MongoDB lokal installiert oder MongoDB Atlas Zugang

IDE wie IntelliJ oder Eclipse


# ⚙️ Projekt Installation & Ausführung


Repository klonen
git clone https://github.com/dein-user/fundgrube.git
cd fundgrube

Spring Boot starten (z. B. über IDE oder CLI)
./mvnw spring-boot:run



# 🌐 API Endpunkte

Methode	Endpoint	    Beschreibung

GET	    /funds	      Liste aller Fundstücke

GET	    /funds/{id}	  Ein Fundstück anzeigen

POST	  /funds	      Neues Fundstück erstellen

PUT	    /funds/{id}	  Fundstück aktualisieren

DELETE	/funds/{id}	  Fundstück löschen



# 🧪 Beispiel JSON (für POST/PUT)

{

  "title": "Java Grundlagen",
  
  "description": "Ein gutes Java-Tutorial",
  
  "url": "https://java-tutorial.de",
  
  "category": "Tutorial"
  
}


# 📁 Projektstruktur

fundgrube/

├── src/
│   └── main/
│       ├── java/ch/wiss/fundgrube/

│       │   ├── controller/

│       │   ├── model/

│       │   └── repository/

│       └── resources/

│           └── application.properties

├── pom.xml

└── README.md



# 👥 Team

Dusan – Backend 

Carmine – Datenbank

Natalia & Anina – API & Test

Natalia & Anina – README 



# ⚠️ Hinweis

Dieses Projekt wurde im Rahmen eines schulischen Lernauftrags entwickelt und ist nicht für den produktiven Einsatz vorgesehen.
