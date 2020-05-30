package com.example.heavymetaljsp.controller;

import com.example.heavymetaljsp.entity.Album;
import com.example.heavymetaljsp.entity.Song;
import com.example.heavymetaljsp.service.AlbumService;
import com.example.heavymetaljsp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    @Autowired
    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping("/song/{id}")
    public String song(@PathVariable String id, Model model) {
        model.addAttribute("song", songService.getSong(id));
        return "/song/song.jsp";
    }

    @GetMapping("/album/{id}/addSong")
    public String addSongForm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute(new Song());
        return "/song/songAddForm.jsp";
    }

    @PostMapping("/album/{albumId}/addSong")
    public String addSong(@PathVariable String albumId, @Valid Song song, Errors errors, Model model) {
        model.addAttribute("id", albumId);
        if (errors.hasErrors()) {
            return "/song/songAddForm.jsp";
        }
        Album album = albumService.getAlbum(albumId);
        song.setAlbum(album);
        songService.addSong(song);
        return "/song/songAdd.jsp";
    }

    @GetMapping("/song/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        model.addAttribute("id", songService.getAlbumId(id));
        songService.deleteSong(id);
        return "/song/songDelete.jsp";
    }

    @GetMapping("/song/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("song", songService.getSong(id));
        return "/song/songEditForm.jsp";
    }

    @PostMapping("/song/{id}/edit")
    public String editSong(@PathVariable String id, @Valid Song song, Errors errors, Model model) {
        model.addAttribute("id", id);
        if (errors.hasErrors()) {
            return "/song/songEditForm.jsp";
        }
        song.setAlbum(albumService.getAlbum(songService.getAlbumId(id)));
        songService.updateSong(song);
        return "/song/songEdit.jsp";
    }
}
