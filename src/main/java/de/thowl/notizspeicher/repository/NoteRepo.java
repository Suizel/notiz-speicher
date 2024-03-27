package de.thowl.notizspeicher.repository;

import de.thowl.notizspeicher.mysql.Note;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository für Notizen
public interface NoteRepo extends JpaRepository<Note, Long> {
}
