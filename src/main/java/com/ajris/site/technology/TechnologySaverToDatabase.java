package com.ajris.site.technology;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnologySaverToDatabase {
    private final TechnologyRepository technologyRepository;
    private static List<String> technologiesList = Arrays.asList("c.svg", "docker.svg", "gradle.svg", "hibernate.png",
            "java.svg", "junit5.png", "maven.svg", "mockito.png", "mongodb.svg", "mysql.svg", "react.svg",
            "spring-boot.svg", "travis.svg");

    public TechnologySaverToDatabase(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @PostConstruct
    public void saveTechnologiesToDatabase(){
        technologyRepository.saveAll(technologiesList.stream().map(TechnologyInformation::new).collect(Collectors.toList()));
    }
}

