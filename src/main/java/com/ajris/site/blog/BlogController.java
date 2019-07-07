package com.ajris.site.blog;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "blog")
    public List<BlogInformation> getBlogInformation() {
        List<BlogInformation> blogInformation = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            blogInformation.add(new BlogInformation());
        }
        return blogInformation;
    }
}
