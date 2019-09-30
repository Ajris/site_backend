package com.ajris.site.blog;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {BlogServiceImpl.class, BlogService.class})
public class BlogServiceImplTest {
    @Autowired
    private BlogService blogService;

    @MockBean
    private BlogRepository blogRepository;

    @Test
    @Disabled
    void shouldGet10ValuesFromGetBlogInformation() {
        Assertions.assertEquals(10, blogService.getAllBlogInformation().join().size());
    }
}
