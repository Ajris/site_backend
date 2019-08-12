package com.ajris.site.blog;

import java.util.List;
import java.util.concurrent.Future;

interface BlogService {
    Future<List<BlogInformation>> getAllBlogInformation();
}
