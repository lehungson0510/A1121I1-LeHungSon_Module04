package codegym.vn.controller;


import codegym.vn.entity.MedicalForm;
import codegym.vn.repository.IElementFormRepo;
import codegym.vn.service.ElementFormServiceImpl;
import codegym.vn.service.IElementFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MedicalFormController {
    IElementFormService elementFormService = new ElementFormServiceImpl();

    @ModelAttribute("medicalForm")
    public MedicalForm initMedicalForm() {
        return new MedicalForm();
    }

    @GetMapping("/display")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("gender", elementFormService.genderList());
        modelAndView.addObject("nationality", elementFormService.nationalityList());
        modelAndView.addObject("travelInfo", elementFormService.travelInfoList());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView save(@ModelAttribute("medicalForm") MedicalForm medicalForm) {
        ModelAndView modelAndView = null;
        Map<String, String> mapError = elementFormService.checkData(medicalForm);
        if (!mapError.isEmpty()) {
            modelAndView = new ModelAndView("form");
            modelAndView.addObject("medicalForm", medicalForm);
            modelAndView.addObject("mapError", mapError);
            modelAndView.addObject("gender", elementFormService.genderList());
            modelAndView.addObject("nationality", elementFormService.nationalityList());
            modelAndView.addObject("travelInfo", elementFormService.travelInfoList());
        } else {
            modelAndView = new ModelAndView("detail");
            modelAndView.addObject("medicalForm", medicalForm);
        }
        return modelAndView;
    }
}
