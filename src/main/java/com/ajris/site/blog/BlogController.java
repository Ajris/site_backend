package com.ajris.site.blog;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "blog")
    public List<BlogInformation> getBlogInformation() {
        return blogService.getAllBlogInformation();
    }
}
