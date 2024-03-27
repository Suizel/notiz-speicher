package de.thowl.notizspeicher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.thowl.notizspeicher.mysql.User;

// Repository für Benutzer
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // Methode zur Suche nach einem Benutzer anhand seiner E-Mail-Adresse
    User findByEmail(String email);
}