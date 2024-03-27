package de.thowl.notizspeicher.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import de.thowl.notizspeicher.mysql.User;
import de.thowl.notizspeicher.web.dto.UserRegistrationDto;

// Service für Benutzer
public interface UserServ extends UserDetailsService {
    // Methode zur Speicherung eines Benutzers anhand der Registrierungsdaten
    User save(UserRegistrationDto registrationDto);
}