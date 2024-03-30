package com.example.hellofullstack.controllers;

import com.example.hellofullstack.services.YatzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
private YatzyService yatzyService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("players", yatzyService.getPlayers());
        return "home/index";
    }
}
