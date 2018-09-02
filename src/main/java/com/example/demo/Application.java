package com.example.demo;

import com.example.demo.data.applink.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
@EnableAutoConfiguration
@ComponentScan({
        "controller",
        "com.example.demo.controller",
        "com.example.demo.data",
        "com.example.demo.data.applink",
})
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    AppLinkService alService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void run(String[] args) {
        try {
            List<AppLink> allAppLinks = alService.findAllAppLinks();
            // if there are no app links (first time usage), initialize them
            if (allAppLinks == null || allAppLinks.isEmpty()) {
                alService.initialize();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
	
}
