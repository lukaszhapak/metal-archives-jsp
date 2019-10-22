package com.example.heavymetaljsp.service;

import com.example.heavymetaljsp.entity.Band;
import com.example.heavymetaljsp.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    private final BandRepository bandRepository;

    @Autowired
    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public List<Band> getBands() {
        return bandRepository.findAll();
    }

    public void addBand(Band band) {
        bandRepository.save(band);
    }

    public void updateBand(Band band) {
        bandRepository.save(band);
    }

    public Band getBand(String id) {
        return bandRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public Band getBand(Long id) {
        return bandRepository.findById(id).orElse(null);
    }

    public void deleteBand(String id) {
        bandRepository.deleteById(Long.parseLong(id));
    }
}
