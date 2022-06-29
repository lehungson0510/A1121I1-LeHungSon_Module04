package codegym.vn.controller;

import codegym.vn.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/display")
    public String displayForm(Model model){
        model.addAttribute("employee",new Employee());
        return "/views/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ("employee") Employee employee, Model model){
        model.addAttribute("employee",employee);
        return "/views/list";

    }
}
