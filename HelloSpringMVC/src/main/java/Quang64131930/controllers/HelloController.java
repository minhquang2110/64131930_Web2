package Quang64131930.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {
	@RequestMapping("say-hello")
	public String SayHello() {
		return "Hello";
	}
}
