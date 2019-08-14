package com.ajris.site.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BlogServiceImpl.class)
public class BlogServiceImplTest {
    @Autowired
    private BlogService blogService;

    @Test
    void shouldGet10ValuesFromGetBlogInformation() {
        Assertions.assertEquals(10, blogService.getAllBlogInformation().join().size());
    }
}
