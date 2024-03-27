package de.thowl.notizspeicher.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller für Benutzerinformationen
@RestController
@RequestMapping("/user")
public class UserCtrl {

    // Mapping zum Abrufen der Benutzer-ID
    @GetMapping
    public UserIdDto getId() {
        return new UserIdDto(1L);
    }

    // Datenübertragungsobjekt für die Benutzer-ID
    @Data
    @AllArgsConstructor
    static class UserIdDto {
        private Long userId;
    }
}