package com.ajris.site.about;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AboutController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "about")
    public List<AboutInformation> getAboutInformation() {
        List<AboutInformation> aboutInformations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            aboutInformations.add(new AboutInformation(((Integer) i).toString(), ((Integer) i).toString()));
        }
        return aboutInformations;
    }
}
