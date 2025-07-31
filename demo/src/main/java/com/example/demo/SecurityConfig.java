package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/hello").permitAll()                    // Public access to hello endpoint
                .requestMatchers("/devtools-demo").permitAll()            // Public access to devtools demo
                .requestMatchers("/logging/**").permitAll()               // Public access to logging demo endpoints
                .requestMatchers("/h2-console/**").permitAll()            // Public access to H2 console
                .requestMatchers("/actuator/health").permitAll()          // Public health check
                .requestMatchers("/actuator/info").permitAll()            // Public app info
                .requestMatchers("/actuator/**").hasRole("ADMIN")         // Admin-only for other actuator endpoints
                .anyRequest().authenticated()                             // All other requests require authentication
            )
            .httpBasic(Customizer.withDefaults())                        // Enable HTTP Basic Authentication
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")                // Disable CSRF for H2 console
                .ignoringRequestMatchers("/api/**")                       // Disable CSRF for API endpoints
                .ignoringRequestMatchers("/actuator/**")                  // Disable CSRF for actuator endpoints
            )
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin())         // Updated non-deprecated syntax
            );
        
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();
            
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("admin123"))
            .roles("USER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
} 