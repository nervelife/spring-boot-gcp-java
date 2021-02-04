package com.nervelife.springbootgcpjava.components;

import com.nervelife.springbootgcpjava.SpringBootGcpJavaApplication;
import com.nervelife.springbootgcpjava.domain.entities.User;
import com.nervelife.springbootgcpjava.domain.repositores.UsersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class StartupComponent {

    private static final Logger log = LoggerFactory.getLogger(SpringBootGcpJavaApplication.class);

    public static final String ADMIN = "admin@nervelife.com";

    @Autowired
    UsersRepository userRepo;

    @EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {

        log.info("~~~___(((( Welcome To NerveLife Soma ))))___~~~");

        User adminUser;	
        try {
            adminUser = userRepo.findByUsername(ADMIN);
        }  catch (EmptyResultDataAccessException erda) {
            log.info("There is no admin been created for this project...");			
            adminUser = new User();
            adminUser.setUsername(ADMIN);
            adminUser.setPassword("123456");
            userRepo.save(adminUser);
     }
    }
    
}
