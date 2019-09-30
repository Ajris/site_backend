package com.ajris.site.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api")
@Slf4j
public class BlogController {

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
}