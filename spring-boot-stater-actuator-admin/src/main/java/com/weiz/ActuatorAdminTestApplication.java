package com.weiz;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class ActuatorAdminTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorAdminTestApplication.class, args);
    }

}
