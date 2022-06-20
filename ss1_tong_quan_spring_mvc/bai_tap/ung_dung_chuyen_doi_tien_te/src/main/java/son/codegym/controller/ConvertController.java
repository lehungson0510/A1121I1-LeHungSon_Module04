package son.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ConvertController {

    @GetMapping("/convert")
    public String display() {
        return "convert";
    }

    @PostMapping("/convert")
    public String calculate(@RequestParam double number, Model model) {
        double result = number * 23000;
        model.addAttribute("result", result);
        model.addAttribute("number", number);
        return "convert";
    }
}
