package com.ajris.site.technology;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Async
    @Override
    public CompletableFuture<List<TechnologyInformation>> getAllTechnologyInformation() {
        return CompletableFuture.completedFuture(technologyRepository.findAll());
    }
}
