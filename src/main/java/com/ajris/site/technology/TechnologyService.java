package com.ajris.site.technology;

import java.util.List;
import java.util.concurrent.CompletableFuture;

interface TechnologyService {
    CompletableFuture<List<TechnologyInformation>> getAllTechnologyInformation();
}
