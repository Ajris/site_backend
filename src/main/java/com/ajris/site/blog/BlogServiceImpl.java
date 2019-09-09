package com.ajris.site.blog;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Async
    @Override
    public CompletableFuture<List<BlogInformation>> getAllBlogInformation() {
        return CompletableFuture.completedFuture(blogRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Long> saveBlog(BlogData blogData) {
        return CompletableFuture.completedFuture(blogRepository.save(new BlogInformation(blogData.getTitle(), blogData.getShortText())).getId());
    }
}
