package com.ajris.site.blog;

import java.util.List;
import java.util.concurrent.CompletableFuture;

interface BlogService {
    CompletableFuture<List<BlogInformation>> getAllBlogInformation();
    CompletableFuture<Long> saveBlog(BlogData blogData);
}
