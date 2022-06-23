package son.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import son.codegym.service.ILanguageService;
import son.codegym.service.LanguageService;

@Controller
public class TranslationController {
    ILanguageService languageService = new LanguageService();


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String text, Model model) {
        String result = languageService.translate(text);
        String mess = "Not found";
        if (result.equals("")) {
            model.addAttribute("mess", mess);
        }
        model.addAttribute("result", result);
        model.addAttribute("text", text);
        return "home";

    }

}
