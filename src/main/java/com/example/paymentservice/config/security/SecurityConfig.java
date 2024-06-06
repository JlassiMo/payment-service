package com.example.paymentservice.config.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll() // Allow access to H2 console
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().permitAll()
                .and().csrf().disable(); // Disable CSRF protection for H2 console

        http.headers().frameOptions().disable(); // Allow the H2 console to be displayed in a frame
    }
}
