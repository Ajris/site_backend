package com.ajris.site.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BLOGINFORMATION")
class BlogInformation {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String shortText;

    public BlogInformation(String title, String shortText) {
        this.title = title;
        this.shortText = shortText;
    }
}
