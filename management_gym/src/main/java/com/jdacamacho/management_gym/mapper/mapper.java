package com.jdacamacho.management_gym.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {

    @Bean
    public ModelMapper createMapper(){
        return new ModelMapper();
    }   
}
