package com.ajris.site.technology;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
class TechnologyServiceImpl implements TechnologyService {
    private static List<String> technologiesList = Arrays.asList("c.svg", "docker.svg", "gradle.svg", "hibernate.png", "java.svg", "junit5.png", "maven.svg", "mockito.png", "mongodb.svg", "mysql.svg", "react.svg", "spring-boot.svg", "travis.svg");

    @Override
    public List<TechnologyInformation> getAllTechnologyInformation() {
        return technologiesList.stream()
                .map(TechnologyInformation::new)
                .collect(Collectors.toList());
    }
}
