package codegym.vn.controller;

import codegym.vn.entity.BoxEmail;
import codegym.vn.repository.ILanguageRepo;
import codegym.vn.repository.IPageSizeRepo;
import codegym.vn.repository.LanguageRepoImpl;
import codegym.vn.service.ILanguageService;
import codegym.vn.service.IPageSizeService;
import codegym.vn.service.LanguageServiceImpl;
import codegym.vn.service.PageSizesServiceImpl;
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
    ILanguageService languageService = new LanguageServiceImpl();
    IPageSizeService pageSizeService = new PageSizesServiceImpl();
    public BoxEmail boxEmailSave = new BoxEmail();

    @ModelAttribute("boxEmail")
    public BoxEmail initBoxEmail() {
        return new BoxEmail();
    }

    @GetMapping("/display")
    public ModelAndView display(@ModelAttribute("boxEmail") BoxEmail boxEmail, Model model) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("boxEmail",boxEmailSave);
        modelAndView.addObject("language", languageService.languageList() );
        modelAndView.addObject("pageSize", pageSizeService.pageSizeList());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView save(@ModelAttribute("boxEmail") BoxEmail boxEmail, Model model) {
        boxEmailSave = boxEmail;
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("language", languageService.languageList() );
        modelAndView.addObject("pageSize", pageSizeService.pageSizeList());
        model.addAttribute("boxEmail", boxEmail);
        return modelAndView;
    }
}
