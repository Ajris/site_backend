package com.ajris.site.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class BlogServiceImpl implements BlogService {
    @Override
    public List<BlogInformation> getAllBlogInformation() {
        List<BlogInformation> blogInformation = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            blogInformation.add(new BlogInformation());
        }
        return blogInformation;
    }
}
