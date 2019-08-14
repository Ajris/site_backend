package com.ajris.site.technology;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@Slf4j
class TechnologyController {

    private TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "technology")
    public ResponseEntity<List<TechnologyInformation>> getTechnologyInformations() {
        return new ResponseEntity<>(technologyService.getAllTechnologyInformation().join(), HttpStatus.ACCEPTED);
    }
}
