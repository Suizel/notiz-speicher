package de.thowl.notizspeicher.web.dto;

// Datenübertragungsobjekt für die Benutzerregistrierung
public class UserRegistrationDto {
    private String firstName; // Vorname des Benutzers
    private String lastName;  // Nachname des Benutzers
    private String email;     // E-Mail-Adresse des Benutzers
    private String password;  // Passwort des Benutzers

    public UserRegistrationDto() {

    }

    // Konstruktor für die Benutzerregistrierung mit Vorname, Nachname, E-Mail und Passwort
    public UserRegistrationDto(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getter und Setter für den Vorname des Benutzers
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter und Setter für den Nachname des Benutzers
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter und Setter für die E-Mail-Adresse des Benutzers
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter und Setter für das Passwort des Benutzers
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}