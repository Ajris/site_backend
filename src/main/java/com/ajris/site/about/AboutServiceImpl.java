package com.ajris.site.about;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AboutServiceImpl implements AboutService {

    @Override
    public List<AboutInformation> getAllAboutInformations() {
        List<AboutInformation> aboutInformations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            aboutInformations.add(new AboutInformation(((Integer) i).toString(), ((Integer) i).toString()));
        }
        return aboutInformations;
    }
}
