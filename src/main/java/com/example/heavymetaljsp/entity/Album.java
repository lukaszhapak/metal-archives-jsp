package com.example.heavymetaljsp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 50, message = "{name.size}")
    private String name;
    @NotNull
    @Pattern(regexp = "19[6789]\\d|20[01]\\d", message = "{year.pattern}")
    private String releaseYear;
    @ManyToOne
    private Band band;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<Song> songs;

    public Album(String name, String releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Album() {
    }
}
