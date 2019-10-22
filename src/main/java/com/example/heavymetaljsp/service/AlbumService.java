package com.example.heavymetaljsp.service;

import com.example.heavymetaljsp.entity.Album;
import com.example.heavymetaljsp.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public void addAlbum(Album album) {
        albumRepository.save(album);
    }

    public Album getAlbum(String id) {
        return albumRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public Album getAlbum(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    public void deleteAlbum(String id) {
        albumRepository.deleteById(Long.parseLong(id));
    }

    public Long getBandId(String id) {
        return albumRepository.getBandId(Long.parseLong(id));
    }

    public void updateAlbum(Album album) {
        albumRepository.save(album);
    }
}
