package com.ajris.site.project;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProjectConfig.class)
public class ProjectServiceImplTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void getAllBlogsReturnEnough() {
        Assertions.assertEquals(10, projectService.getAllProjectInformation().size());
    }
}
