package com.backend.jwt.api;

import com.backend.jwt.api.config.Swagger3Config;
import com.backend.jwt.api.entity.User;
import com.backend.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@Import(Swagger3Config.class)
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
