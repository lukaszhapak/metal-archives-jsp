package com.example.heavymetaljsp.repository;

import com.example.heavymetaljsp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
