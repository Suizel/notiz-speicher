package de.thowl.notizspeicher.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import de.thowl.notizspeicher.mysql.Role;
import de.thowl.notizspeicher.mysql.User;
import de.thowl.notizspeicher.repository.UserRepo;
import de.thowl.notizspeicher.web.dto.UserRegistrationDto;

@Service
public class UserServImpl implements UserServ {

    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        // Erstelle einen neuen Benutzer mit den Registrierungsdaten
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER")));

        // Speichere den Benutzer in der Datenbank
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Suche den Benutzer in der Datenbank anhand der E-Mail-Adresse
        User user = userRepo.findByEmail(username);

        if(user == null) {
            throw new UsernameNotFoundException("Ungültiger Benutzername oder Passwort.");
        }

        // Erstelle ein UserDetails-Objekt mit den Benutzerinformationen und Rollen
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    // Abbildung der Benutzerrollen auf Spring Security Authorities
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}