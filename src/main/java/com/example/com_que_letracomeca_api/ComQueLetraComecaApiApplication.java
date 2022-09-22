package com.example.com_que_letracomeca_api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ComQueLetraComecaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComQueLetraComecaApiApplication.class, args);
    }
}
