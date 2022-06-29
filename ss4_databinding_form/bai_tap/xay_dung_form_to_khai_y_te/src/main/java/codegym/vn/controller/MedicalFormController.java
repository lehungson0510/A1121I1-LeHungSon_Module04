package codegym.vn.controller;


import codegym.vn.entity.MedicalForm;
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
        ModelAndView modelAndView = null;
        Map<String, String > mapError = new HashMap<>();
        if (medicalForm.getName().equals("")){
            mapError.put("name","Bạn chưa nhập mục này");
        }
        if (medicalForm.getBirthday().equals("")){
            mapError.put("birthday","Bạn chưa nhập mục này");
        }
        if (medicalForm.getIdCard().equals("")){
            mapError.put("idCard","Bạn chưa nhập mục này");
        }
        if (medicalForm.getTravelInfo()== null){
            mapError.put("travelInfo","Bạn chưa nhập mục này");
        }
        if (medicalForm.getNumberVehicle().equals("")){
            mapError.put("numberVehicle","Bạn chưa nhập mục này");
        }
        if (medicalForm.getNumberSeat().equals("")){
            mapError.put("numberSeat","Bạn chưa nhập mục này");
        }
        if (medicalForm.getDateStart().equals("")){
            mapError.put("dateStart","Bạn chưa nhập mục này");
        }
        if (medicalForm.getDateEnd().equals("")){
            mapError.put("dateEnd","Bạn chưa nhập mục này");
        }
        if (medicalForm.getExtraInfo().equals("")){
            mapError.put("extraInfo","Bạn chưa nhập mục này");
        }
        if(!mapError.isEmpty()){
            modelAndView = new ModelAndView("form");
            modelAndView.addObject("medicalForm",medicalForm);
            modelAndView.addObject("mapError",mapError);
            modelAndView.addObject("gender", new String[]{"Nam", "Nữ"});
            modelAndView.addObject("nationality", new String[]{"Việt Nam", "Thái Lan","Lào","Campuchia"});
            modelAndView.addObject("travelInfo", new String[]{"Tàu bay", "Tàu thuyền","Ô tô","Khác (Ghi rõ)"});
        } else {
            modelAndView = new ModelAndView("detail");
            modelAndView.addObject("medicalForm",medicalForm);
        }
        return modelAndView;
    }


}
