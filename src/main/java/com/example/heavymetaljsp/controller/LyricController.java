package com.example.heavymetaljsp.controller;

import com.example.heavymetaljsp.entity.Lyric;
import com.example.heavymetaljsp.entity.Song;
import com.example.heavymetaljsp.service.LyricService;
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
public class LyricController {

    private final LyricService lyricService;
    private final SongService songService;

    @Autowired
    public LyricController(LyricService lyricService, SongService songService) {
        this.lyricService = lyricService;
        this.songService = songService;
    }

    @GetMapping("/song/{id}/addLyric")
    public String addLyricForm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute(new Lyric());
        return "/lyric/lyricAddForm.jsp";
    }

    @PostMapping("/song/{songId}/addLyric")
    public String addLyric(@PathVariable String songId, @Valid Lyric lyric, Errors errors, Model model) {
        model.addAttribute("id", songId);
        if (errors.hasErrors()) {
            return "/lyric/lyricAddForm.jsp";
        }
        Song song = songService.getSong(songId);
        lyric.setSong(song);
        lyricService.addLyric(lyric);
        return "/lyric/lyricAdd.jsp";
    }

    @GetMapping("/lyric/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        model.addAttribute("id", lyricService.getSongId(id));
        lyricService.deleteLyric(id);
        return "/lyric/lyricDelete.jsp";
    }

    @GetMapping("/lyric/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("lyric", lyricService.getLyric(id));
        return "/lyric/lyricEditForm.jsp";
    }

    @PostMapping("/lyric/{id}/edit")
    public String editLyric(@PathVariable String id, @Valid Lyric lyric, Errors errors, Model model) {
        model.addAttribute("id", lyricService.getSongId(id));
        if (errors.hasErrors()) {
            return "/lyric/lyricEditForm.jsp";
        }
        lyric.setSong(songService.getSong(lyricService.getSongId(id)));
        lyricService.updateLyric(lyric);

        return "/lyric/lyricEdit.jsp";
    }
}
