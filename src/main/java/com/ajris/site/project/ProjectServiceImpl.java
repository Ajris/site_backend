package com.ajris.site.project;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl( ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Async
    @Override
    public CompletableFuture<List<ProjectInformation>> getAllProjectInformation() {
        return CompletableFuture.completedFuture(projectRepository.findAll());
    }
}