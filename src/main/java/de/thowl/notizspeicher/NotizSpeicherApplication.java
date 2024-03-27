package de.thowl.notizspeicher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Hauptklasse für die Registrierung, Anmeldung und Sicherheit einer Spring Boot-Anwendung mit Thymeleaf.

@SpringBootApplication
public class NotizSpeicherApplication {

    // Hauptmethode für den Start der Spring Boot-Anwendung
    public static void main(String[] args) {
        SpringApplication.run(NotizSpeicherApplication.class, args);
    }

}