package de.thowl.notizspeicher.mysql;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titel;
    private String inhalt;
    private String kategorie;

    // Datum und Uhrzeit, wann die Notiz erstellt wurde
    @Column(name = "erstellungszeitpunkt")
    private String erstellungszeitpunkt;

    @ManyToOne
    @JoinColumn(name = "benutzer_id")
    private User benutzer;

    // Konstruktor, Getter und Setter für die Attribute

    // Konstruktor, um eine Notiz mit Titel, Inhalt, Kategorie und Benutzer zu erstellen
    public Note(String titel, String inhalt, String kategorie, User benutzer) {
        this.titel = titel;
        this.inhalt = inhalt;
        this.kategorie = kategorie;
        this.benutzer = benutzer;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
        this.erstellungszeitpunkt = dateFormat.format(new Date());
    }
}