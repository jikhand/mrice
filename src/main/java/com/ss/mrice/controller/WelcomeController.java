package com.ss.mrice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String helloMessage;
	
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		System.out.println("WELCOME");
		model.put("message", helloMessage);
		
		return "dash1";
	}
}