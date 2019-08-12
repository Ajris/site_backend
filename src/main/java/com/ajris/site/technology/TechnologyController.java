package com.ajris.site.technology;

import io.swagger.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
        try{
            return new ResponseEntity<>(technologyService.getAllTechnologyInformation().get(), HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e){
            log.error(e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.ACCEPTED);
        }
    }
}
