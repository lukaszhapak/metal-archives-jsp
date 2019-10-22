package com.example.heavymetaljsp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size
    @Size(min = 3, max = 50, message = "{name.size}")
    private String name;
    @NotNull
    @Pattern(regexp = "\\d\\d.[12345]\\d|\\d.[12345]\\d", message = "{duration.pattern}")
    private String duration;
    @ManyToOne
    private Album album;
    @OneToOne(mappedBy = "song", cascade = CascadeType.REMOVE)
    private Lyric lyric;

    public Song(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public Song() {
    }
}
