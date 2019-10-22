package com.example.heavymetaljsp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Lyric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Song song;
    @NotNull
    @Size(min = 1, max = 10000, message = "{text.size}")
    @Column(columnDefinition = "TEXT")
    private String text;

    public Lyric(String text) {
        this.text = text;
    }

    public Lyric() {
    }
}
