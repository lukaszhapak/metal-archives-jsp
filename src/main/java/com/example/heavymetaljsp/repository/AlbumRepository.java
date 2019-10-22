package com.example.heavymetaljsp.repository;

import com.example.heavymetaljsp.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("select b.id from Album a inner join Band b on a.band.id = b.id where a.id = ?1")
    Long getBandId(long albumId);
}
