package com.ajris.site.technology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@AllArgsConstructor
@Entity
@Table(name = "TECHNOLOGIES")
class TechnologyInformation {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String pathToImage;

    public TechnologyInformation(String name) {
        this.name = name;
    }
}
