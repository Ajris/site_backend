package com.ajris.site.technology;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TechnologyController {

    private TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "technology")
    public List<TechnologyInformation> getTechnologyInformations() {
        return technologyService.getAllTechnologyInformation();
    }
}
