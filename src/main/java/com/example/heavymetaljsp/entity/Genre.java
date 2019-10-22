package com.example.heavymetaljsp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 50, message = "{name.size}")
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Band> bands;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}
