package de.thowl.notizspeicher.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.thowl.notizspeicher.service.UserServ;
import de.thowl.notizspeicher.web.dto.UserRegistrationDto;

// Controller für die Benutzerregistrierung
@Controller
@RequestMapping("/registration")
public class UserRegCtrl {

    private UserServ userServ;

    public UserRegCtrl(UserServ userServ) {
        super();
        this.userServ = userServ;
    }

    // Model-Attribute für das Benutzerregistrierungs-DTO
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    // Mapping für die Anzeige des Registrierungsformulars
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    // Mapping für die Verarbeitung der Benutzerregistrierung
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userServ.save(registrationDto);
        return "redirect:/registration?success";
    }
}