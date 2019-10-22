package com.example.heavymetaljsp.repository;

import com.example.heavymetaljsp.entity.Lyric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LyricRepository extends JpaRepository<Lyric, Long> {

    @Query("select s.id from Lyric l inner join Song s on l.song.id = s.id where l.id = ?1")
    Long getSongId(long lyricId);
}
