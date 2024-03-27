package de.thowl.notizspeicher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class FilterChainConfig {

    // Bean für das Passwort-Encoder-Objekt
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean für die Konfiguration der Sicherheitsfilterkette
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/notes/**", "/notes"))
                .authorizeHttpRequests(authorize -> authorize
                        // Erlauben bestimmter URLs ohne Authentifizierung
                        .requestMatchers("/registration**", "/static/**", "/images/**").permitAll()
                        // Authentifizierung für bestimmte URLs erforderlich
                        .requestMatchers("/index**", "/dashboard**").authenticated()
                        // Standardmäßig Authentifizierung für alle anderen URLs erforderlich
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login").permitAll()
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout").permitAll()
                );
        return http.build();
    }
}