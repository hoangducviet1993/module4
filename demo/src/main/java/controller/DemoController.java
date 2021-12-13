package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

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
    @GetMapping("/trans")
    public String translate(Model model){
        return "trans";
    }
    @PostMapping("/trans")
    public String translate(Model model, @RequestParam String word) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
        dictionary.put("chicken", "con gà");
        String result = dictionary.get(word);
        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Not found");
        }
        return "trans";
    }
}
