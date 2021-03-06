package son.codegym.controller;

import son.codegym.entity.Blog;
import son.codegym.entity.Category;
import son.codegym.service.IBlogService;
import son.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;

    @GetMapping("/blog-list-category/{id}")
    public String viewBlogList(@PathVariable("id") Integer id, Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Blog> blogList = blogService.findAllByCategory(id, pageable);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blogList",blogList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("id", id);
        return "category/list";
    }

    @ModelAttribute("category")
    public Category init() {
        return new Category();
    }

    @GetMapping("/list")
    public String display(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "category/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xo?? Category th??nh c??ng");
        return "redirect:/blog/list";
    }

    @GetMapping("/create")
    public String viewCreate() {
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("mess", "Th??m m???i Category th??nh c??ng");
        return "redirect:/blog/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Edit Category th??nh c??ng");
        return "redirect:/blog/list";
    }
}
