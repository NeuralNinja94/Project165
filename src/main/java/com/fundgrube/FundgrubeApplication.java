package com.fundgrube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hauptklasse der Fundgrube-Anwendung.
 * Startet die Spring Boot Applikation.
 */
@SpringBootApplication
public class FundgrubeApplication {
    /**
     * Einstiegspunkt der Anwendung.
     * @param args Programmargumente
     */
    public static void main(String[] args) {
        SpringApplication.run(FundgrubeApplication.class, args);
    }
}
