package com.ajris.site.technology;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TechnologyConfig.class)
public class TechnologyServiceImplTest {

    @Autowired
    private TechnologyService technologyService;

    @Test
    public void getAllBlogsReturnEnough() {
        Assertions.assertEquals(10, technologyService.getAllTechnologyInformation().size());
    }
}
