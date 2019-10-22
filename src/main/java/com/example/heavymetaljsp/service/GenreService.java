package com.example.heavymetaljsp.service;

import com.example.heavymetaljsp.entity.Band;
import com.example.heavymetaljsp.entity.Genre;
import com.example.heavymetaljsp.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(String id) {
        genreRepository.deleteById(Long.parseLong(id));
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public List<Genre> getGenres(Band band) {
        List<Genre> genres = genreRepository.findAll();
        for (Genre genre : band.getGenres()) {
            genres.remove(genre);
        }
        return genres;
    }

    public Genre getGenre(String id) {
        return genreRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public Genre getGenre(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }
}
