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
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 50, message = "{name.size}")
    private String name;
    @NotNull
    @Size(min = 3, max = 50, message = "{country.size}")
    private String country;
    @NotNull
    @Pattern(regexp = "19[6789]\\d|20[01]\\d", message = "{year.pattern}")
    private String formedIn;
    @OneToMany(mappedBy = "band", cascade = CascadeType.REMOVE)
    private List<Album> albums;
    @ManyToMany
    @JoinTable(
            name = "band_genre",
            joinColumns =
            @JoinColumn(name = "band_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genres;

    public Band(String name, String country, String formedIn) {
        this.name = name;
        this.country = country;
        this.formedIn = formedIn;
    }

    public Band() {
    }
}
