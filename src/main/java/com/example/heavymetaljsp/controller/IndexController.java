package com.example.heavymetaljsp.controller;

import com.example.heavymetaljsp.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping({"/", "/index", "/home"})
    public String get(Model model) {

        model.addAttribute("bandsCount", indexService.getBandsCount());
        model.addAttribute("albumsCount", indexService.getAlbumsCount());
        model.addAttribute("songsCount", indexService.getSongsCount());

        return "/index.jsp";
    }
}
