package son.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import son.codegym.entity.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public String form(Model model){
        model.addAttribute("user",new User());
        return "/list";
    }

    @PostMapping("/enroll")
    public String validate(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "không thành công");
            return "/list";
        }else {
            model.addAttribute("mess", "thành công");
        }
        return "/list";
    }
}
