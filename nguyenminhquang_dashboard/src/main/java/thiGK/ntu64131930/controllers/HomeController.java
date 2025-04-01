package thiGK.ntu64131930.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64131930.models.Page;
import thiGK.ntu64131930.models.Post;

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
    ArrayList<Post> posts = new ArrayList<Post>() {{
        add(new Post("1", "Post Title 1", "This is the content of post 1", "1"));
        add(new Post("2", "Post Title 2", "This is the content of post 2", "2"));
        add(new Post("3", "Post Title 3", "This is the content of post 3", "3"));
        add(new Post("4", "Post Title 4", "This is the content of post 4", "4"));
        add(new Post("5", "Post Title 5", "This is the content of post 5", "5"));
        add(new Post("6", "Post Title 6", "This is the content of post 6", "6"));
        add(new Post("7", "Post Title 7", "This is the content of post 7", "7"));
        add(new Post("8", "Post Title 8", "This is the content of post 8", "8"));
        add(new Post("9", "Post Title 9", "This is the content of post 9", "9"));
        add(new Post("10", "Post Title 10", "This is the content of post 10", "10"));
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
	
	@GetMapping("page/new")
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
	
	
	
	@GetMapping("post/all")
	public String postPage(Model model) {
		model.addAttribute("ds",posts);
		model.addAttribute("content","postList");
		return "layout";
	}
	
	@GetMapping("post/new")
	public String postAdd(Model model) {
		model.addAttribute("content","postAdd");
		return "layout";
	}
	
	@GetMapping("post/addNew")
	public String postAddNew(@RequestParam(name="title") String name,@RequestParam(name="categoryId") String prname,Model model) {
		String id=String.format("%02d", posts.size());
		posts.add(new Post(id, name," ",prname));
		model.addAttribute("content","postAdd");
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