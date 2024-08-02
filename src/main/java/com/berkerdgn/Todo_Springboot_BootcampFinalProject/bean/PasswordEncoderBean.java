package com.berkerdgn.Todo_Springboot_BootcampFinalProject.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderBean {

    @Bean
    public PasswordEncoder passwordEncoderMethode() {
        return new BCryptPasswordEncoder();
    }// end passwordEncoderMethode method

} // end PasswordEncoderBean class
