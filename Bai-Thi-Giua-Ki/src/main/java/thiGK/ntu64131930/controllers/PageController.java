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
public class PageController{
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
        add(new Page("11", "Khuyến mãi", "promotion, sale", "Thông tin khuyến mãi", "1"));
        add(new Page("12", "Trang chủ", "home, welcome", "Nội dung trang chủ", "2"));
        add(new Page("23", "Giới thiệu", "about, info", "Nội dung về công ty", "1"));
        add(new Page("35", "Dịch vụ", "services, offer", "Nội dung dịch vụ", "1"));
        add(new Page("41", "Liên hệ", "contact, phone", "Thông tin liên hệ", "1"));
        add(new Page("51", "Sản phẩm", "products, catalog", "Thông tin sản phẩm", "1"));
        add(new Page("61", "Tin tức", "news, updates", "Thông tin tin tức", "1"));
        add(new Page("71", "Chính sách", "policy, terms", "Thông tin chính sách", "1"));
        add(new Page("81", "Hướng dẫn", "guide, tutorial", "Nội dung hướng dẫn", "1"));
        add(new Page("91", "FAQs", "faq, question", "Các câu hỏi thường gặp", "1"));
        add(new Page("110", "Khuyến mãi", "promotion, sale", "Thông tin khuyến mãi", "1"));
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
	public String index() {
		return "/html/layout.html";
	}
	@GetMapping("page/all")
	public String pageAll(Model model) {
		model.addAttribute("ds",pages);
		model.addAttribute("content","pageList");
		return "/html/layout.html";
	}
	@GetMapping("page/new")
	public String pageAdd(Model model) {
		model.addAttribute("content","pageAdd");
		return "/html/layout.html";
	}
	@PostMapping("page/add")
	public String pageAddHandle(Model model,@RequestParam(name="pageName") String name,@RequestParam(name="keyword") String key,@RequestParam(name="content") String content,@RequestParam(name="parentPageId") String parentId) {
		String id=pages.size()+1+"";
		pages.add(new Page(id, name, key, content, parentId));
		model.addAttribute("content","pageAdd");
		return "/html/layout.html";
	}
	@PostMapping("page/delete/id")
	public String pageDeleteHandle(Model model,@RequestParam(name="id") String id) {
		for (Page i:pages) {
			if(i.getId().equals(id)) {
				pages.remove(i);
				break;
			}
		}
		model.addAttribute("ds",pages);
		model.addAttribute("content","pageList");
		return "/html/layout.html";
	}
	@PostMapping("page/view/id")
	public String pageViewHandle(Model model,@RequestParam(name="idx") int index ) {
		model.addAttribute("ob",pages.get(index));
		model.addAttribute("content","pageDetail");
		return "/html/layout.html";
	}
	
}