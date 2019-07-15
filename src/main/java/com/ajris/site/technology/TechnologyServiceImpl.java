package com.ajris.site.technology;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TechnologyServiceImpl implements TechnologyService {
    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<TechnologyInformation> getAllTechnologyInformation() {
        return technologyRepository.findAll();
    }
}
