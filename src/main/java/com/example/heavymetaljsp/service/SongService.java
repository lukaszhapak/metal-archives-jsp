package com.example.heavymetaljsp.service;

import com.example.heavymetaljsp.entity.Song;
import com.example.heavymetaljsp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void addSong(Song song) {
        songRepository.save(song);
    }

    public Song getSong(String id) {
        return songRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public Song getSong(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public void deleteSong(String id) {
        songRepository.deleteById(Long.parseLong(id));
    }

    public void updateSong(Song song) {
        songRepository.save(song);
    }

    public Long getAlbumId(String id) {
        return songRepository.getAlbumId(Long.parseLong(id));
    }
}
