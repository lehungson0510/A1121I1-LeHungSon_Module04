package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import son.codegym.entity.User;
import son.codegym.service.IUserService;
import son.codegym.validate.UserValidation;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String form(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("/enroll")
    public String validate(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        UserValidation validation = new UserValidation();
        validation.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "không thành công");
            return "/create";
        }else {
            model.addAttribute("mess", "thành công");
            userService.save(user);

        }
        return "/create";
    }
}
