package com.dailycodebuffer.websocket.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user-1").password("{noop}1234").authorities("ADMIN").and()
                .withUser("user-2").password("{noop}1234").authorities("MANAGER").and()
                .withUser("user-3").password("{noop}1234").authorities("MANAGER");
    }
}
