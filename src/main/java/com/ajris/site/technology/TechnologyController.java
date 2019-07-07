package com.ajris.site.technology;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TechnologyController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "technology")
    public List<TechnologyInformation> getTechnologyInformations() {
        List<TechnologyInformation> technologyInformations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            technologyInformations.add(new TechnologyInformation());
        }
        return technologyInformations;
    }
}
