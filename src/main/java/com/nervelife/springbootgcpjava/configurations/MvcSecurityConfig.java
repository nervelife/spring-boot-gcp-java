package com.nervelife.springbootgcpjava.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MvcSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService appUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/**").permitAll()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/private/**").authenticated()
            //.antMatchers("/admin/**").fullyAuthenticated()
            .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
            .antMatchers("/login/handle").anonymous()
            .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginProcessingUrl("/login/handle")
        .and()
            .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(appUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
}
