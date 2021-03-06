package com.spring_security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication().withUser(users.username("fuadik88").password("rembo1").roles("ADMIN", "EMPLOYEE"))
                .withUser(users.username("masterkill7").password("master").roles("EMPLOYEE"))
                .withUser(users.username("harry").password("osborn").roles("MANAGER", "EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/management/**").hasRole("MANAGER")
                .antMatchers("/system/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/signin")
                .loginProcessingUrl("/auth").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/nowayin");
    }
}
