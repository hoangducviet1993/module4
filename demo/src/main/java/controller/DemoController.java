package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    @GetMapping("/")
    public String greeting() {
        return "index";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("name", "Value Name");
        return "edit";
    }

    @GetMapping("/sum")
    public String showSum(Model model, @RequestParam double a, @RequestParam double b) {
        model.addAttribute("sum", a + b);
        return "sum";
    }

    @PostMapping("/sum")
    public String showSum2(Model model, @RequestParam double a, @RequestParam double b) {
        model.addAttribute("sum", a + b);
        return "sum";
    }

    @GetMapping("/currency")
    public String currency1(Model model){
        return "currency";
    }

    @PostMapping("/currency")
    public String currency(Model model, @RequestParam double usd, @RequestParam double curr) {
        model.addAttribute("currency", usd * curr);
        return "currency";
    }

}
