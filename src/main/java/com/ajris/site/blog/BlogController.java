package com.ajris.site.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import java.security.Principal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
@Slf4j
class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @CrossOrigin
    @GetMapping(path = "blog")
    public ResponseEntity<List<BlogInformation>> getBlogInformation() {
        return new ResponseEntity<>(blogService.getAllBlogInformation().join(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @PostMapping(path = "blog")
    public ResponseEntity<Long> saveBlog(@RequestBody BlogData blogData) {
        return new ResponseEntity<>(blogService.saveBlog(blogData).join(), HttpStatus.CREATED);
    }

    @GetMapping("/home")
    @SuppressWarnings("unchecked")
    @CrossOrigin
    public String howdy(Model model, Principal principal) {
        OAuth2Authentication authentication = (OAuth2Authentication) principal;
        Map<String, Object> user = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
        model.addAttribute("user", user);
        return "home";
    }
}