package com.ajris.site.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
class ProjectInformation {
    private String name;
    private String html_url;
    private String description;

    public ProjectInformation() {
    }

}
