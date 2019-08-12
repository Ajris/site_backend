package com.ajris.site.technology;

import java.util.List;
import java.util.concurrent.Future;

interface TechnologyService {
    Future<List<TechnologyInformation>> getAllTechnologyInformation();
}
