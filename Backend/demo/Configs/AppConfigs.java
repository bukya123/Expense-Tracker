package com.example.demo.Configs;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AppConfigs {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
