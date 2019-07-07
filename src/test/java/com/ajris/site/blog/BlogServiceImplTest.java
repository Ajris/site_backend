package com.ajris.site.blog;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BlogConfig.class)
public class BlogServiceImplTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void getAllBlogsReturnEnough() {
        Assertions.assertEquals(10, blogService.getAllBlogInformation().size());
    }
}
