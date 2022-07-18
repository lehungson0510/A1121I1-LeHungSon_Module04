package son.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @GetMapping("")
    public String list(){
        return "list";
    }

    @PostMapping("/user")
    public String create(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("than")
        return "list";
    }

}