package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping("/")
    public String showCal() {
        return "index";
    }

    @GetMapping("/cal")
    public String success(Model model, @RequestParam String cal, int a, int b) {
        int result=0;
        switch (cal) {
            case "plus":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
            case "multi":
                result = a * b;
                break;
            case "divide":
                result = a / b;
                break;
        }
        model.addAttribute("result",result);
        return "index";
    }
}
