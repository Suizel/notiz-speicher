package de.thowl.notizspeicher.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import de.thowl.notizspeicher.service.UserServ;

@Configuration
public class SecConfig {

    @Autowired
    private UserServ userServ;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Bean für den AuthenticationProvider, der den benutzerdefinierten UserServ verwendet
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userServ);
        auth.setPasswordEncoder(bCryptPasswordEncoder);
        return auth;
    }

}