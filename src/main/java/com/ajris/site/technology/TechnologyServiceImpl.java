package com.ajris.site.technology;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class TechnologyServiceImpl implements TechnologyService{
    @Override
    public List<TechnologyInformation> getAllTechnologyInformation() {
        List<TechnologyInformation> technologyInformations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            technologyInformations.add(new TechnologyInformation("1", "1"));
        }
        return technologyInformations;
    }
}
