package com.example.heavymetaljsp.controller;

import com.example.heavymetaljsp.entity.Genre;
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
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String getGenres(Model model) {
        model.addAttribute("genres", genreService.getGenres());
        return "/genre/genres.jsp";
    }

    @GetMapping("/genre/add")
    public String addGenreForm(Model model) {
        model.addAttribute(new Genre());
        return "/genre/genreAddForm.jsp";
    }

    @PostMapping("/genre/add")
    public String addGenre(@Valid Genre genre, Errors errors) {
        if (errors.hasErrors()) {
            return "/genre/genreAddForm.jsp";
        }
        genreService.addGenre(genre);
        return "/genre/genreAdd.jsp";
    }

    @GetMapping("/genre/{id}/delete")
    public String delete(@PathVariable String id) {
        genreService.deleteGenre(id);
        return "/genre/genreDelete.jsp";
    }

    @GetMapping("/genre/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("genre", genreService.getGenre(id));
        return "/genre/genreEditForm.jsp";
    }

    @PostMapping("/genre/{id}/edit")
    public String editGenre(@Valid Genre genre, Errors errors) {
        if (errors.hasErrors()) {
            return "/genre/genreEditForm.jsp";
        }
        genreService.updateGenre(genre);
        return "/genre/genreEdit.jsp";
    }
}
