package quangnm.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import quangnm.models.Personal;

@Controller
public class HomeController{
	@GetMapping("/")
	public String home() {
		return "homePage";
	}
	
	@GetMapping("/aboutMe")
	public String profile(Model model) {
		model.addAttribute("content","profile");
		return "homePage";
	}
	@GetMapping("/list")
	public String getList(Model model) {
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
		dsSinhVien.add(new Personal("64131940", "Dương Minh Hoàng", 2005, false));
		dsSinhVien.add(new Personal("64131941", "Dương Minh Hoàng", 2005, false));
		model.addAttribute("dsSV",dsSinhVien);
		model.addAttribute("content","list");
		return "homePage";
	}
	@GetMapping("/add")
	public String getAdd(Model model) {
		model.addAttribute("content","addNew");
		return "homePage";
	}
}