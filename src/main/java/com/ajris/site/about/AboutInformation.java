package com.ajris.site.about;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "about", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
class AboutInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "smallInformation")
    private String smallInformation;

    @Column(name = "largeInformation")
    private String largeInformation;
}
