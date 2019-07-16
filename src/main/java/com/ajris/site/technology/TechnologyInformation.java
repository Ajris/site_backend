package com.ajris.site.technology;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class TechnologyInformation {
    private String name;
    private String pathToImage;

    public TechnologyInformation(String name) {
        this.name = name;
    }
}
