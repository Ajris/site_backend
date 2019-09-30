package com.ajris.site.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROJECTINFORMATION")
class ProjectInformation {
    @Id
    private Long id;
    private String name;
    private String html_url;
    private String description;
    private String image;
}
