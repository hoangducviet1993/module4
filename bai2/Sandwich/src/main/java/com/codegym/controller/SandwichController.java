package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @GetMapping("/")
    public String show() {
        return "index";
    }

    @GetMapping("/save")
    public String showResult(Model model, @RequestParam("condiment") String[] condiment) {
        model.addAttribute("condiment", condiment);
        return "success";
    }
}
