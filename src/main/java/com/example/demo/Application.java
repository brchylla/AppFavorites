package com.example.demo;

import com.example.demo.data.applink.*;
import com.example.demo.data.userapps.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by ben chylla on 9/1/18.
 */
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
    @Autowired
    UserAppsService uaService;

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
            // if there are no users (first time usage), initialize them
            List<UserApps> allUsers = uaService.getAllUsers();
            if (allUsers == null || allUsers.isEmpty()) {
            	uaService.initialize();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
	
}
