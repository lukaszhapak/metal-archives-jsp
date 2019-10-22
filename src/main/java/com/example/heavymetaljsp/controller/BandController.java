package com.example.heavymetaljsp.controller;

import com.example.heavymetaljsp.entity.Band;
import com.example.heavymetaljsp.entity.Genre;
import com.example.heavymetaljsp.service.BandService;
import com.example.heavymetaljsp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BandController {

    private final BandService bandService;
    private final GenreService genreService;

    @Autowired
    public BandController(BandService bandService, GenreService genreService) {
        this.bandService = bandService;
        this.genreService = genreService;
    }

    @GetMapping("/bands")
    public String bands(Model model) {
        model.addAttribute("bands", bandService.getBands());
        return "/band/bands.jsp";
    }

    @GetMapping("/band/{id}")
    public String band(@PathVariable String id, Model model) {
        model.addAttribute("band", bandService.getBand(id));
        return "/band/band.jsp";
    }

    @GetMapping("/band/add")
    public String form(Model model) {
        model.addAttribute(new Band());
        return "/band/bandAddForm.jsp";
    }

    @PostMapping("/band/add")
    public String add(@Valid Band band, Errors errors) {
        if (errors.hasErrors()) {
            return "/band/bandAddForm.jsp";
        }
        bandService.addBand(band);
        return "/band/bandAdd.jsp";
    }

    @GetMapping("/band/{id}/delete")
    public String delete(@PathVariable String id) {
        bandService.deleteBand(id);
        return "/band/bandDelete.jsp";
    }

    @GetMapping("/band/{id}/addGenre")
    public String addGenreForm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("genre", new Genre());
        model.addAttribute("genres", genreService.getGenres(bandService.getBand(id)));
        return "/band/bandAddGenreForm.jsp";
    }

    @PostMapping("/band/{id}/addGenre")
    public String addGenre(@PathVariable String id, Genre genre, Model model) {
        model.addAttribute("id", id);
        Band band = bandService.getBand(id);
        band.getGenres().add(genreService.getGenre(genre.getId()));
        bandService.updateBand(band);
        return "/band/bandAddGenre.jsp";
    }

    @GetMapping("/band/{id}/deleteGenre")
    public String deleteGenreForm(@PathVariable String id, Model model) {
        model.addAttribute("genres", bandService.getBand(id).getGenres());
        model.addAttribute("id", id);
        model.addAttribute("genre", new Genre());
        return "/band/bandDeleteGenreForm.jsp";
    }

    @PostMapping("/band/{id}/deleteGenre")
    public String deleteGenre(@PathVariable String id, Genre genre, Model model) {
        model.addAttribute("id", id);
        Band band = bandService.getBand(id);
        band.getGenres().remove(genreService.getGenre(genre.getId()));
        bandService.updateBand(band);
        return "/band/bandDeleteGenre.jsp";
    }

    @GetMapping("/band/{id}/edit")
    public String editBandForm(@PathVariable String id, Model model) {
        model.addAttribute(bandService.getBand(id));
        return "/band/bandEditForm.jsp";
    }

    @PostMapping("/band/{id}/edit")
    public String editBand(@PathVariable String id, @Valid Band band, Errors errors, Model model) {
        model.addAttribute("id", id);

        if (errors.hasErrors()) {
            return "/band/bandEditForm.jsp";
        }
        bandService.updateBand(band);
        return "/band/bandEdit.jsp";
    }
}
