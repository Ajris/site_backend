package com.ajris.site.blog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogInformation> getAllBlogInformation() {
        return blogRepository.findAll();
    }
}
