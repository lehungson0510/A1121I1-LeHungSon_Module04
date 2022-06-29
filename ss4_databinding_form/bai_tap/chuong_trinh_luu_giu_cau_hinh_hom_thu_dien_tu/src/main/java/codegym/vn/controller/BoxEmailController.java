package codegym.vn.controller;

import codegym.vn.entity.BoxEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BoxEmailController {
    public BoxEmail boxEmailSave = new BoxEmail();

    @ModelAttribute("boxEmail")
    public BoxEmail initBoxEmail() {
        return new BoxEmail();
    }

    @GetMapping("/display")
    public ModelAndView display(@ModelAttribute("boxEmail") BoxEmail boxEmail, Model model) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("boxEmail",boxEmailSave);
        modelAndView.addObject("language", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSize", new String[]{"5", "10", "15", "25", "50", "100"});
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView save(@ModelAttribute("boxEmail") BoxEmail boxEmail, Model model) {
        boxEmailSave = boxEmail;
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("language", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSize", new String[]{"5", "10", "15", "25", "50", "100"});
        model.addAttribute("boxEmail", boxEmail);
        return modelAndView;
    }
}
