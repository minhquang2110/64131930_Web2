package quangnm.controllers;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("truyenDsObject")
	public String transportData(Model model) {
		ArrayList<Personal> dsSinhVien=new ArrayList<Personal>();
		dsSinhVien.add(new Personal("64131930", "Nguyễn Minh Quang", 2004, true));
		dsSinhVien.add(new Personal("64131931", "Trần Thị Lan", 2003, false));
		dsSinhVien.add(new Personal("64131932", "Phạm Văn Hùng", 2005, true));
		dsSinhVien.add(new Personal("64131933", "Lê Minh Tuấn", 2004, true));
		dsSinhVien.add(new Personal("64131934", "Hoàng Thị Mai", 2003, false));
		dsSinhVien.add(new Personal("64131935", "Đoàn Ngọc Sơn", 2002, true));
		dsSinhVien.add(new Personal("64131936", "Vũ Thị Thanh", 2005, true));
		dsSinhVien.add(new Personal("64131937", "Ngô Minh Tiến", 2004, false));
		dsSinhVien.add(new Personal("64131938", "Bùi Thị Nhung", 2003, true));
		dsSinhVien.add(new Personal("64131939", "Dương Minh Hoàng", 2005, false));
		model.addAttribute("dsSV",dsSinhVien);
		return "transport";
	}
	@PostMapping("/profile")
	public String profilePost(@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
		if(email.equals("minhquang")&&password.equals("12345")) {
			Personal personal=new Personal("64131930", "Nguyễn Minh Quang", 2004, true);
			model.addAttribute("personal",personal);
			return("index");
		}
		return "loginPage";
	}
	@GetMapping("/profile")
	public String profileGet(@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
		if(email.equals("minhquang")&&password.equals("12345")) {
			Personal personal=new Personal("64131930", "Nguyễn Minh Quang", 2004, true);
			model.addAttribute("personal",personal);
			return("index");
		}
		return("loginPage");
	}
	@GetMapping("/login")
	public String loginHandler() {
		return "loginPage";
	}
	
	@GetMapping("/bmi")
	public String bmiHandler() {
		return "bmiPage";
	}

	@GetMapping("/bmiGet")
	public String bmiGet(@RequestParam("height") float height,@RequestParam("weight") float weight,Model model) {
		float resultCalculation=(float) (weight/(Math.pow(height/100,2)));
		String result;
		if(resultCalculation>=40) result="Béo phì cấp độ III";
		else
			if(resultCalculation>=30) result="Béo phì cấp độ II";
			else 
				if(resultCalculation>=25) result="Béo phì cấp độ I";
				else 
					if(resultCalculation>=23) result="Thừa cân";
					else
						if(resultCalculation>18.5) result="Bình thường";
						else result="Gầy";
		model.addAttribute("result",result);
		model.addAttribute("resultCalculation",resultCalculation);
		return "bmiPage";
	}
	
	@PostMapping("/bmiPost")
	public String bmiPost(@RequestParam("height") float height,@RequestParam("weight") float weight,Model model) {
		float resultCalculation=(float) (weight/(Math.pow(height/100,2)));
		String result;
		if(resultCalculation>=40) result="Béo phì cấp độ III";
		else
			if(resultCalculation>=30) result="Béo phì cấp độ II";
			else 
				if(resultCalculation>=25) result="Béo phì cấp độ I";
				else 
					if(resultCalculation>=23) result="Thừa cân";
					else
						if(resultCalculation>18.5) result="Bình thường";
						else result="Gầy";
		model.addAttribute("result",result);
		model.addAttribute("resultCalculation",resultCalculation);
		return "bmiPage";
	}
	
}