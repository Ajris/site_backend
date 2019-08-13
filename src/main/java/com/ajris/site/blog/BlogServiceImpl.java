package com.ajris.site.blog;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
class BlogServiceImpl implements BlogService {
    @Async
    @Override
    public CompletableFuture<List<BlogInformation>> getAllBlogInformation() {
        List<BlogInformation> blogInformation = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            blogInformation.add(new BlogInformation("1", "1"));
        }
        return CompletableFuture.completedFuture(blogInformation);
    }
}
