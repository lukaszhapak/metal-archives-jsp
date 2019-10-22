package com.example.heavymetaljsp.repository;

import com.example.heavymetaljsp.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("select a.id from Song s inner join Album a on s.album.id = a.id where s.id = ?1")
    Long getAlbumId(long albumId);
}
