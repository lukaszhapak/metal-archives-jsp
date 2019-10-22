package com.example.heavymetaljsp.repository;

import com.example.heavymetaljsp.entity.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
