package com.ajris.site.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@Slf4j
class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @CrossOrigin
    @GetMapping(path = "project")
    public ResponseEntity<List<ProjectInformation>> getProjectInformation() {
        return new ResponseEntity<>(projectService.getAllProjectInformation().join(), HttpStatus.ACCEPTED);
    }
}
