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
import java.util.Optional;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable, @RequestParam("name") Optional<String> name) {
        List<Category> categoryList = categoryService.findAll();
        Page<Blog> blogList;
        if(name.isPresent()) {
            blogList = blogService.search(name.get(), pageable);
            model.addAttribute("name", name.get());
        } else {
            blogList = blogService.findAll(pageable);
        }
        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "blog/list";
    }


    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();

        Blog blog = new Blog();
        blog.setCategory(new Category());

        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryList);
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryList);
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/blog/list";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam("name") String name, Model model, @PageableDefault(value = 4) Pageable pageable) {
//        Page<Blog> blogList = blogService.search(name, pageable);
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("blogList", blogList);
//        model.addAttribute("categoryList", categoryList);
//        return "blog/list";
//    }
}
