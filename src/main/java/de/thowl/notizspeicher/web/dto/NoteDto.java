package de.thowl.notizspeicher.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// Datenübertragungsobjekt für Notizen
@Data
@AllArgsConstructor
public class NoteDto {
    private String titel; // Titel der Notiz
    private String inhalt; // Inhalt der Notiz
    private String kategorie; // Kategorie der Notiz
    private Long benutzerId; // ID des Benutzers, dem die Notiz gehört
}