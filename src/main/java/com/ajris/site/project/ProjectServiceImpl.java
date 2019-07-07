package com.ajris.site.project;

import com.ajris.site.blog.BlogInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectInformation> getAllProjectInformation() {
        List<ProjectInformation> projectInformations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            projectInformations.add(new ProjectInformation());
        }
        return projectInformations;
    }
}
