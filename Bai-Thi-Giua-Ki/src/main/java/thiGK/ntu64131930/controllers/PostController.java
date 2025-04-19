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
public class PostController{
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
    
    @GetMapping("post/new")
	public String pageAdd(Model model) {
		model.addAttribute("content","postAdd");
		return "/html/layout.html";
	}
    @PostMapping("post/add")
	public String pageAddHandle(Model model,@RequestParam(name="title") String name,@RequestParam(name="content") String value,@RequestParam(name="categoryId") String cId) {
		String id=posts.size()+1+"";
		posts.add(new Post(id, name, value, cId));
		model.addAttribute("content","postAdd");
		return "/html/layout.html";
	}
	@GetMapping("post/all")
	public String postAll(Model model) {
		model.addAttribute("ds",posts);
		model.addAttribute("content","postList");
		return "/html/layout.html";
	}
	@PostMapping("post/view/id")
	public String postViewHandle(Model model,@RequestParam(name="idx") int index ) {
		model.addAttribute("ob",posts.get(index));
		model.addAttribute("content","postDetail");
		return "/html/layout.html";
	}
	@PostMapping("post/delete/id")
	public String pageDeleteHandle(Model model,@RequestParam(name="id") String id) {
		for (Post i:posts) {
			if(i.getId().equals(id)) {
				posts.remove(i);
				break;
			}
		}
		model.addAttribute("ds",posts);
		model.addAttribute("content","postList");
		return "/html/layout.html";
	}
	
}