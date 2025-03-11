package quangnm.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quangnm.models.Personal;


@Controller
public class HomeController{
	@GetMapping("/")
	public String home(Model model) {
		Personal personal=new Personal("64131930", "Nguyễn Minh Quang", 2004, true);
		model.addAttribute("personal",personal);
		return "index";
	}
	
}