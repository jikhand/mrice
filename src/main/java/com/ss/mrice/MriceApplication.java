package com.ss.mrice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages={"com.ss.*"})
public class MriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MriceApplication.class, args);
	}
	  


}
