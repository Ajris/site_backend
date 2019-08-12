package com.ajris.site.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
        try {
            return new ResponseEntity<>(projectService.getAllProjectInformation().get(), HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.REQUEST_TIMEOUT);
        }
    }
}
