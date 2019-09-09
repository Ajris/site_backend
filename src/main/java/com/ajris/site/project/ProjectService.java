package com.ajris.site.project;

import java.util.List;
import java.util.concurrent.CompletableFuture;

interface ProjectService {
    CompletableFuture<List<ProjectInformation>> getAllProjectInformation();
}
