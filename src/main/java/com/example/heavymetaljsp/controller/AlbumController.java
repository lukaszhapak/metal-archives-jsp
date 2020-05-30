package com.example.heavymetaljsp.controller;

import com.example.heavymetaljsp.entity.Album;
import com.example.heavymetaljsp.entity.Band;
import com.example.heavymetaljsp.service.AlbumService;
import com.example.heavymetaljsp.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AlbumController {

    private final BandService bandService;
    private final AlbumService albumService;

    @Autowired
    public AlbumController(BandService bandService, AlbumService albumService) {
        this.bandService = bandService;
        this.albumService = albumService;
    }

    @GetMapping("/album/{id}")
    public String album(@PathVariable String id, Model model) {
        model.addAttribute("album", albumService.getAlbum(id));
        return "/album/album.jsp";
    }

    @GetMapping("/band/{id}/addAlbum")
    public String addAlbumForm(@PathVariable String id, Model model) {
        model.addAttribute(new Album());
        model.addAttribute("id", id);
        return "/album/albumAddForm.jsp";
    }

    @PostMapping("/band/{bandId}/addAlbum")
    public String addAlbum(@PathVariable String bandId, @Valid Album album, Errors errors, Model model) {
        model.addAttribute("id", bandId);
        if (errors.hasErrors()) {
            return "/album/albumAddForm.jsp";
        }
        Band band = bandService.getBand(bandId);
        album.setBand(band);
        albumService.addAlbum(album);
        return "/album/albumAdd.jsp";
    }

    @GetMapping("/album/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        model.addAttribute("id", albumService.getBandId(id));
        albumService.deleteAlbum(id);
        return "/album/albumDelete.jsp";
    }

    @GetMapping("/album/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("album", albumService.getAlbum(id));
        return "/album/albumEditForm.jsp";
    }

    @PostMapping("/album/{id}/edit")
    public String editAlbum(@PathVariable String id, @Valid Album album, Errors errors, Model model) {
        model.addAttribute("id", id);
        if (errors.hasErrors()) {
            return "/album/albumEditForm.jsp";
        }
        album.setBand(bandService.getBand(albumService.getBandId(id)));
        albumService.updateAlbum(album);
        return "/album/albumEdit.jsp";
    }
}
