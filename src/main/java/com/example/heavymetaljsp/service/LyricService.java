package com.example.heavymetaljsp.service;

import com.example.heavymetaljsp.entity.Lyric;
import com.example.heavymetaljsp.repository.LyricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LyricService {

    private final LyricRepository lyricRepository;

    @Autowired
    public LyricService(LyricRepository lyricRepository) {
        this.lyricRepository = lyricRepository;
    }

    public void addLyric(Lyric lyric) {
        lyricRepository.save(lyric);
    }

    public Lyric getLyric(String id) {
        return lyricRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public void deleteLyric(String id) {
        lyricRepository.deleteById(Long.parseLong(id));
    }

    public void updateLyric(Lyric lyric) {
        lyricRepository.save(lyric);
    }

    public Long getSongId(String id) {
        return lyricRepository.getSongId(Long.parseLong(id));
    }
}
