package com.ajris.site.project;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

interface ProjectService {
    List<ProjectInformation> getAllProjectInformation() throws IOException;
}
