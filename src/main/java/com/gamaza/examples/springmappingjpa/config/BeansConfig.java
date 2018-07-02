package com.gamaza.examples.springmappingjpa.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean(name = "dozer")
    public DozerBeanMapper dozer(){
        return new DozerBeanMapper();
    }

}
