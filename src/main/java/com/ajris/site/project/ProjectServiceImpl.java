package com.ajris.site.project;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
class ProjectServiceImpl implements ProjectService {

    private final RestTemplate restTemplate;

    public ProjectServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    @Override
    public CompletableFuture<List<ProjectInformation>> getAllProjectInformation() {
        return CompletableFuture.completedFuture(getContent());
    }

    private List<ProjectInformation> getContent() {
        String url = "https://api.github.com/users/ajris/repos?page=1&per_page=100";

        ResponseEntity<List<ProjectInformation>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }
}