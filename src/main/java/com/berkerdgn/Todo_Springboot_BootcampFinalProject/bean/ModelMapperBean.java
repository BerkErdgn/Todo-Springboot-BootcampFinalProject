package com.berkerdgn.Todo_Springboot_BootcampFinalProject.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {

    @Bean
    public ModelMapper getModelMapperMethod() {
        return new ModelMapper();
    }// end modelMapperMethod method
}// end ModelMapperBean class
