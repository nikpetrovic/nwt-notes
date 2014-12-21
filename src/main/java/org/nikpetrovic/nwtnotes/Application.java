package org.nikpetrovic.nwtnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EntityScan(basePackages = "org.nikpetrovic.nwtnotes.entities")
public class Application {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
