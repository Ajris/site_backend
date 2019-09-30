package com.ajris.site.project;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProjectDownloader {
    private final RestTemplate restTemplate;
    private final ProjectRepository projectRepository;

    public ProjectDownloader(RestTemplate restTemplate, ProjectRepository projectRepository) {
        this.restTemplate = restTemplate;
        this.projectRepository = projectRepository;
    }

    @PostConstruct
    public void downloadProjectsAndSaveToDatabase() {
        String url = "https://api.github.com/users/ajris/repos?page=1&per_page=100";

        ResponseEntity<List<ProjectInformation>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        List<ProjectInformation> projectInformations = response.getBody();
        projectRepository.saveAll(projectInformations);
    }
}
