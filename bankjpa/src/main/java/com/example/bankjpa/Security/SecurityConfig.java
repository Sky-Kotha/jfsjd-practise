package com.example.bankjpa.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig<T> {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService);
        return authenticationManagerBuilder.build();
    }

    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.userDetailsService( userDetailsService);
    // }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                // .cors(AbstractHttpConfigurer::disable)
                // .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/bal/{userId}").hasAuthority("ADMIN")
                        .requestMatchers("/users").hasAuthority("USER")// hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/").authenticated())
                .formLogin();
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // Define your password encoder here, for example:
        return NoOpPasswordEncoder.getInstance();
    }

}
