package com.WebServices.BOSWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class testWeb {
	@GetMapping("/test/{uname}")
	public String test(@PathVariable String uname) {
		return "Welcome "+ uname + " **** Happy Diwali **** ";
		
	}
}
