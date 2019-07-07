package com.ajris.site.project;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "project")
    public List<ProjectInformation> getProjectInformations() {
        return projectService.getAllProjectInformation();
    }
}
