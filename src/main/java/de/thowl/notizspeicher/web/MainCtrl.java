package de.thowl.notizspeicher.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controller für Hauptseiten der Anwendung
@Controller
@Slf4j
public class MainCtrl {
    // Mapping für die Login-Seite
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Mapping für die Startseite
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Mapping für das Dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}