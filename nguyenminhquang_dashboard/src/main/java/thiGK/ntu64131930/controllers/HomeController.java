package thiGK.ntu64131930.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64131930.models.Page;

@Controller
public class HomeController{
	ArrayList<Page> pages = new ArrayList<Page>() {{
        add(new Page("1", "Trang chủ", "home, welcome", "Nội dung trang chủ", "2"));
        add(new Page("2", "Giới thiệu", "about, info", "Nội dung về công ty", "1"));
        add(new Page("3", "Dịch vụ", "services, offer", "Nội dung dịch vụ", "1"));
        add(new Page("4", "Liên hệ", "contact, phone", "Thông tin liên hệ", "1"));
        add(new Page("5", "Sản phẩm", "products, catalog", "Thông tin sản phẩm", "1"));
        add(new Page("6", "Tin tức", "news, updates", "Thông tin tin tức", "1"));
        add(new Page("7", "Chính sách", "policy, terms", "Thông tin chính sách", "1"));
        add(new Page("8", "Hướng dẫn", "guide, tutorial", "Nội dung hướng dẫn", "1"));
        add(new Page("9", "FAQs", "faq, question", "Các câu hỏi thường gặp", "1"));
        add(new Page("10", "Khuyến mãi", "promotion, sale", "Thông tin khuyến mãi", "1"));
    }};
	@GetMapping("/")
	public String home() {
		return "layout";
	}
	@GetMapping("page/all")
	public String getPage(Model model) {
		model.addAttribute("ds",pages);
		model.addAttribute("content","pageList");
		return "layout";
	}
	
	@GetMapping("page/add")
	public String pageAdd(Model model) {
		model.addAttribute("content","pageAdd");
		return "layout";
	}
	
	@GetMapping("page/addNew")
	public String pageAddNew(@RequestParam(name="PageName") String name,@RequestParam(name="parentPageId") String prname,Model model) {
		String id=String.format("%02d", pages.size());
		pages.add(new Page(id, name," "," ",prname));
		model.addAttribute("content","pageAdd");
		return "layout";
	}
	
//	@GetMapping
//	public String getAdd() {
//		return "pageAdd";
//	}
//	
//	@PostMapping
//	public String postPage() {
//		return "postList";
//	}
//	@PostMapping
//	public String postAdd() {
//		return "postAdd";
//	}
	
}