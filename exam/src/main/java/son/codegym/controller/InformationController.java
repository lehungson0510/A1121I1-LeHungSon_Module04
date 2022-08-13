package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import son.codegym.entity.Category;
import son.codegym.entity.Information;
import son.codegym.service.category.IInformationService;
import son.codegym.service.information.ICategoryService;
import son.codegym.validation.ValidationInformation;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/information")
public class InformationController {
    @Autowired
    IInformationService informationService;

    @Autowired
    ICategoryService categoryService;

    @ModelAttribute("categories")
    List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 2, sort = "title", direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam(name = "titleSearch") Optional<String> titleSearch,
                             @RequestParam(name = "categorySearch") Optional<String> categorySearch) {
        Page<Information> informations;
        String condition = "";
        ModelAndView modelAndView = new ModelAndView("information/list");
        if (titleSearch.isPresent() || categorySearch.isPresent()) {
            informations = informationService.findAllSearch(titleSearch.get(), categorySearch.get(), pageable);

            if (informations.isEmpty()) {
                modelAndView.addObject("mess", "Không tìm thấy");
            }
            if (titleSearch.isPresent()) {
                condition += "&titleSearch=" + titleSearch.get();
                modelAndView.addObject("titleSearch", titleSearch.get());

            }
            if (categorySearch.isPresent()) {
                condition += "&categorySearch=" + categorySearch.get();
                modelAndView.addObject("categorySearch", categorySearch.get());
            }
        } else informations = informationService.findAll(pageable);

        modelAndView.addObject("informations", informations);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        Information information = new Information();
        information.setCategoryId(new Category());
        model.addAttribute("information", information);
        return "/information/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("information") Information information, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        ValidationInformation validate = new ValidationInformation();
        validate.validate(information, bindingResult);
        if (information.getCategoryId() == null) {
            information.setCategoryId(new Category());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Thêm mới thất bại");
            model.addAttribute("information", information);
            return "/information/create";
        }

        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        informationService.create(information);
        return "redirect:/information/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") int id, RedirectAttributes redirectAttributes) {
        informationService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/information/list";
    }
}
