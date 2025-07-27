package com.example.WebApp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello, World!";
	}
	
	@RequestMapping("/bruno")
	public @ResponseBody String greetingFulano() {
		return "Hello, Bruno!";
	}
	
	@RequestMapping("/greeting")
	public @ResponseBody String greetingQueryParam(@RequestParam("param") String param) {
		return "Hello " + param + "!";
	}
	
	@RequestMapping("/greeting/{param}")
	public @ResponseBody String greetingUrlParam(@PathVariable("param") String param) {
		return "Hello " + param + "!";
	}
}