package com.rizomm.m2.tp.translations.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String key;

    @NotBlank
    private String value;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Translation translation;

}
