# Project165


📚 Fundgrube – Schulprojekt
Ist eine Webanwendung zur Verwaltung von verlorenen Gegenständen. Die Anwendung basiert auf einem modernen Java-Backend mit MongoDB-Datenbankanbindung.


## ✅ Funktionen

🔍 Fundstücke anzeigen (`GET /funds`)

➕ Neues Fundstück erfassen (`POST /funds`)

📝 Fundstück bearbeiten (`PUT /funds/{id}`)

🗑️ Fundstück löschen (`DELETE /funds/{id}`)

# 

#### 💾 Daten werden in einer MongoDB gespeichert

#### 🔗 REST API mit Spring Boot

## 🛠️ Tech-Stack


Komponente	      Beschreibung

Java 17+      ->  Hauptprogrammiersprache

Spring Boot	  ->	Backend-Framework & Webservice

MongoDB	      ->	NoSQL Datenbank

Maven	        ->	Build Tool

Postman	      ->	Zum Testen der REST-API



## 🚀 Projekt starten

### 🔧 Voraussetzungen

Java 17+

Maven

MongoDB lokal installiert oder MongoDB Atlas Zugang

IDE wie IntelliJ oder Eclipse


## ⚙️ Projekt Installation & Ausführung


Repository klonen
git clone https://github.com/dein-user/fundgrube.git
cd fundgrube

Spring Boot starten (z. B. über IDE oder CLI)
./mvnw spring-boot:run



## 🌐 API Endpunkte

Methode	Endpoint	    Beschreibung

GET	    /funds	      Liste aller Fundstücke

GET	    /funds/{id}	  Ein Fundstück anzeigen

POST	  /funds	      Neues Fundstück erstellen

PUT	    /funds/{id}	  Fundstück aktualisieren

DELETE	/funds/{id}	  Fundstück löschen



## 🧪 Beispiel JSON (für POST/PUT)

{

  "title": "Java Grundlagen",
  
  "description": "Ein gutes Java-Tutorial",
  
  "url": "https://java-tutorial.de",
  
  "category": "Tutorial"
  
}


## 📁 Projektstruktur
 
fundgrube-datenbank
 
├── src
 
│   └── main
 
│       ├── java/ch/wiss/fundgrube/
 
│           ├── controller
 
                └── ArtikelController.java
 
│       │   ├── exception
 
                └── GlobalExceptionHandler.java
 
│       │   ├── model
 
                └── Abholung.java
 
                └── Artikel.java
 
                └── Schueler.java
 
│       │   ├── repository
 
                └── ArtikelRepository.java
│       │   ├── service
 
                └── ArtikelService.java
 
            └── FundgrubeApplication.java
│       ├── resources
 
│       │   ├── static
 
│       │   ├── templates
 
│           └── application.properties
 
│   ├── test\java\com\fundgrube
 
│       ├── Integrationstest
 
            └── ArtikelFindByBezeichnungIT.java
 
            └── ArtikelFindByStandortIT.java
 
            └── ArtikelRepositoryIT.java
 
│       ├── Mocktest
 
            └── ArtikelMockMvcTest.java
 
│       ├── Smoketest
 
            └── SmokeTest.java
 
│       ├── Unittest
 
            └── ArtikelControllerTest.java
 
            └── unitTest.java
 
        └── FundgrubeApplicationTest.java
 
├── target
 
│   ├── classes
 
│   ├── generated-sources
 
│   ├── generated-test-sources
 
│   ├── maven-archiver
 
│   ├── maven-status\maven-complier-plugin
 
│       ├── compile
 
│       ├── testCompile
 
│   ├── surefire-reports
 
│   ├── test-classes\com\fundgrube
 
│       ├── Integrationstest
 
│       ├── Unittest
 
        ├── FundgrubeApplicationTest.class
 
├── pom.xml
 
└── README.md



## 👥 Team

Dusan – Backend 

Carmine – Datenbank

Natalia & Anina – API & Test

Natalia & Anina – README 



## ⚠️ Hinweis

Dieses Projekt wurde im Rahmen eines schulischen Lernauftrags entwickelt und ist nicht für den produktiven Einsatz vorgesehen.
