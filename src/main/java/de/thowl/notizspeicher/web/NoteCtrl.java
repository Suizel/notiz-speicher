package de.thowl.notizspeicher.web;

import de.thowl.notizspeicher.mysql.Note;
import de.thowl.notizspeicher.service.NoteServ;
import de.thowl.notizspeicher.web.dto.NoteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controller für Notizen
@RestController
@RequestMapping("/notes")
@Slf4j
public class NoteCtrl {

    @Autowired
    private NoteServ noteServ;

    // Abrufen aller Notizen
    @GetMapping
    public List<Note> alleNotizenAbrufen() {
        return noteServ.alleNotizenAbrufen();
    }

    // Abrufen einer Notiz anhand ihrer ID
    @GetMapping("/{id}")
    public ResponseEntity<Note> notizNachIdAbrufen(@PathVariable Long id) {
        Optional<Note> notiz = noteServ.notizNachIdAbrufen(id);
        return notiz.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Speichern einer neuen Notiz
    @PostMapping
    public ResponseEntity<Note> notizSpeichern(@RequestBody NoteDto notiz) {
        log.info("{}", notiz);
        Note gespeicherteNotiz = noteServ.notizSpeichern(notiz);
        return new ResponseEntity<>(gespeicherteNotiz, HttpStatus.CREATED);
    }

    // Löschen einer Notiz anhand ihrer ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> notizLöschen(@PathVariable Long id) {
        noteServ.notizLöschen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}