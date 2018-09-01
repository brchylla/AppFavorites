package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void run(String[] args) {
        try {
            //mfService.syncMutualFundsAsync(new URL(mutualFundURL), Duration.ofHours(1));
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
	
}
