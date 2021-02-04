package com.nervelife.springbootgcpjava.configurations;

import com.nervelife.springbootgcpjava.domain.entities.User;
import com.nervelife.springbootgcpjava.domain.repositores.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = usersRepo.findByUsername(username);
        if ( user != null ) {
            return  org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException(String.format("User =%s was not found", username));
    }
    
}