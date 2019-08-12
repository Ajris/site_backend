package com.ajris.site.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api")
@Slf4j
class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "blog")
    public ResponseEntity<List<BlogInformation>> getBlogInformation() {
        try {
            return new ResponseEntity<>(blogService.getAllBlogInformation().get(), HttpStatus.ACCEPTED);
        } catch (ExecutionException | InterruptedException e) {
            log.error("BLOG ERROR");
            log.error(e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.REQUEST_TIMEOUT);
        }
    }
}