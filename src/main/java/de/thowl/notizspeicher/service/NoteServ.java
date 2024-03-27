package de.thowl.notizspeicher.service;

import de.thowl.notizspeicher.mysql.Note;
import de.thowl.notizspeicher.mysql.User;
import de.thowl.notizspeicher.repository.NoteRepo;
import de.thowl.notizspeicher.repository.UserRepo;
import de.thowl.notizspeicher.web.dto.NoteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service für Notizen
@Service
@Slf4j
public class NoteServ {

    @Autowired
    private NoteRepo notizRepository;

    @Autowired
    private UserRepo userRepo;

    // Abrufen aller Notizen
    public List<Note> alleNotizenAbrufen() {
        return notizRepository.findAll();
    }

    // Abrufen einer Notiz anhand ihrer ID
    public Optional<Note> notizNachIdAbrufen(Long id) {
        return notizRepository.findById(id);
    }

    // Speichern einer Notiz
    public Note notizSpeichern(NoteDto notiz) {
        User benutzer = userRepo.findById(notiz.getBenutzerId()).orElseThrow(() -> new RuntimeException("User not " +
                "found"));
        log.info("{}", notiz.getInhalt());
        Note note = new Note(notiz.getTitel(), notiz.getInhalt(), notiz.getKategorie(), benutzer);
        log.info("{}", note.getInhalt());
        return notizRepository.save(note);
    }

    // Löschen einer Notiz anhand ihrer ID
    public void notizLöschen(Long id) {
        notizRepository.deleteById(id);
    }
}