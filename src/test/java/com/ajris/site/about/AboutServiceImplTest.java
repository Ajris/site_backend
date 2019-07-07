package com.ajris.site.about;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AboutConfig.class)
public class AboutServiceImplTest {

    @Autowired
    private AboutService aboutService;

    @Test
    public void getAllBlogsReturnEnough() {
        Assertions.assertEquals(10,aboutService.getAllAboutInformations().size());
    }
}
