package com.owlsdonttalk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.owlsdonttalk.Server")
public class AppConfig {

    @Bean
    public void ClientMain(){}

    @Bean
    public void ServerMain(){}

}
