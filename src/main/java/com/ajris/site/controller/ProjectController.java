package com.ajris.site.controller;

import com.ajris.site.model.ProjectInformation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "project")
    public List<ProjectInformation> getProjectInformations() {
        List<ProjectInformation> projectInformations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            projectInformations.add(new ProjectInformation());
        }
        return projectInformations;
    }
}
