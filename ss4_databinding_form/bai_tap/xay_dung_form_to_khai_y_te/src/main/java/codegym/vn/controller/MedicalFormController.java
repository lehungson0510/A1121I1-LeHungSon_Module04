package codegym.vn.controller;


import codegym.vn.entity.MedicalForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalFormController {
    @ModelAttribute("medicalForm")
    public MedicalForm initMedicalForm() {
        return new MedicalForm();
    }

    @GetMapping("/display")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("gender", new String[]{"Nam", "Nữ"});
        modelAndView.addObject("nationality", new String[]{"Việt Nam", "Thái Lan","Lào","Campuchia"});
        modelAndView.addObject("travelInfo", new String[]{"Tàu bay", "Tàu thuyền","Ô tô","Khác (Ghi rõ)"});
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView save(@ModelAttribute ("medicalForm") MedicalForm medicalForm){
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("medicalForm",medicalForm);
        return modelAndView;
    }


}
