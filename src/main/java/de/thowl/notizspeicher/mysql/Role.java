package de.thowl.notizspeicher.mysql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Entität für Benutzerrollen
@Table(name = "role")
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Eindeutige Identifikationsnummer der Rolle

	// Getter und Setter für den Namen der Rolle
	@Getter
	@Setter
	private String name; // Name der Rolle

	public Role() {

	}

	// Konstruktor für eine neue Rolle mit einem Namen
	public Role(String name) {
		super();
		this.name = name;
	}

}