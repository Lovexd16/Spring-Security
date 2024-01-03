package com.intro.springsecurityintro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //Styr vem som når vad
        
        http
        .authorizeHttpRequests((request) -> request
            .requestMatchers("/api/v1/greetings/welcome").permitAll() //alla kommer åt
            .requestMatchers("/api/v1/greetings/goodbye").denyAll() //ingen kommer åt
            .anyRequest().authenticated() //alla kommer åt alla andra
        )
        .formLogin(Customizer.withDefaults()) //om denna failar går den till httpBasic
        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User.withDefaultPasswordEncoder()
        .username("love")
        .password("love")
        .build();

         UserDetails user2 = User.withDefaultPasswordEncoder()
        .username("johan")
        .password("johan")
        .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
