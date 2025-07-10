package com.fundgrube;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Integrationstest für die Spring Boot Anwendung.
 *
 * Dieser Test prüft, ob der Spring ApplicationContext erfolgreich geladen werden kann.
 * Damit wird sichergestellt, dass die grundlegende Spring-Konfiguration korrekt ist
 * und alle Beans ohne Fehler erstellt werden können.
 */
@SpringBootTest
class FundgrubeApplicationTests {

	/**
	 * Leerer Test, der nur prüft, ob der ApplicationContext ohne Fehler startet.
	 * Wird von Spring Boot automatisch als Smoke-Test für die Konfiguration verwendet.
	 */
	@Test
	void contextLoads() {
	}

}
