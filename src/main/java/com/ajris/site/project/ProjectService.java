package com.ajris.site.project;

import java.util.List;
import java.util.concurrent.Future;

interface ProjectService {
    Future<List<ProjectInformation>> getAllProjectInformation();
}
