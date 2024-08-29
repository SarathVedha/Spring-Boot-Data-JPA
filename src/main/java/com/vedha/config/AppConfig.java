package com.vedha.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
public class AppConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
