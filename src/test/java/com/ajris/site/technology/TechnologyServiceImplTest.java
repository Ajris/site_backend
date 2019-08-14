package com.ajris.site.technology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = TechnologyServiceImpl.class)
public class TechnologyServiceImplTest {
    @Autowired
    private TechnologyService technologyService;

    @Test
    public void shouldGet13ValuesFromGetTechnologyInformation() {
        Assertions.assertEquals(13, technologyService.getAllTechnologyInformation().join().size());
    }
}
