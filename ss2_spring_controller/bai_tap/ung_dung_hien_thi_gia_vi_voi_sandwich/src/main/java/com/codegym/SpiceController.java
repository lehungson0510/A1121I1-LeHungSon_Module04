package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SpiceController {

    @GetMapping("/spice")
    public String home() {
        return "home";
    }

    @PostMapping("/spice")
    public String display(@RequestParam("spice") String spiceArr, Model model) {
        model.addAttribute("spice", spiceArr);
        return "home";
    }
}