package son.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerDisplay {

    @GetMapping("/hello")
    public String displayHello() {
        return "hello";
    }

    @PostMapping("/name")
    public String displayHelloAndName(@RequestParam String name, Model model) {
        model.addAttribute("text", name);
        return "hello";
    }
}
