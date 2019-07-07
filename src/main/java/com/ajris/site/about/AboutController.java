package com.ajris.site.about;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AboutController {

    private AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "about")
    public List<AboutInformation> getAboutInformation() {
        return aboutService.getAllAboutInformations();
    }
}
