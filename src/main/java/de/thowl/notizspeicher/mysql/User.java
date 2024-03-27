package de.thowl.notizspeicher.mysql;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Collection;

// Entität für Benutzer
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Eindeutige Identifikationsnummer des Benutzers

    @Column(name = "first_name")
    private String firstName; // Vorname des Benutzers

    @Column(name = "last_name")
    private String lastName; // Nachname des Benutzers

    // Getter für die E-Mail-Adresse des Benutzers
    @Getter
    private String email; // E-Mail-Adresse des Benutzers

    // Getter für das Passwort des Benutzers
    @Getter
    private String password; // Passwort des Benutzers

    // Getter für die Rollen des Benutzers
    // Rollen, die dem Benutzer zugeordnet sind
    @Getter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {

    }

    // Konstruktor für einen neuen Benutzer mit Vorname, Nachname, E-Mail, Passwort und Rollen
    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}