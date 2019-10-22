package com.example.heavymetaljsp.service;

import com.example.heavymetaljsp.repository.AlbumRepository;
import com.example.heavymetaljsp.repository.BandRepository;
import com.example.heavymetaljsp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    private final BandRepository bandRepository;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    @Autowired
    public IndexService(BandRepository bandRepository, AlbumRepository albumRepository, SongRepository songRepository) {
        this.bandRepository = bandRepository;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public long getBandsCount() {
        return bandRepository.count();
    }

    public long getAlbumsCount() {
        return albumRepository.count();
    }

    public long getSongsCount() {
        return songRepository.count();
    }
}
