package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import son.codegym.entity.Factory;
import son.codegym.entity.Product;
import son.codegym.service.IFactoryNameService;
import son.codegym.service.IProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService IProductService;

    @Autowired
    private IFactoryNameService IFactoryNameService;

//
//    @GetMapping(value = "/list"
////        consumes = {MediaType.APPLICATION_JSON_VALUE}
////            ,headers = {"Content-Type=text/html","Accept=application/xml"}
//            )
//    public String list(Model model) {
//        List<Product> products = service.findAll();
//        model.addAttribute("product", products);
//        return "product/list";
//    }

//    @GetMapping("/view/{student_id}")
//    public String viewStudent(@PathVariable("student_id") String id, Model model) {
//        Student student = service.findById(id);
//        model.addAttribute("student", student);
//        return "/student/view";
//    }

    // Dùng formatter
    @GetMapping("/view/{product_id}")
    public String viewProduct(@PathVariable("product_id") Product product, Model model) {
        model.addAttribute("product", product);
        return "/product/view";
    }

    @GetMapping("/delete/{product_id}")
    public String deleteProduct(@PathVariable("product_id") String id, RedirectAttributes redirectAttributes) {
        IProductService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{product_id}")
    public String showFormUpdateProduct(@PathVariable("product_id") String id, Model model) {
        List<Factory> factories = IFactoryNameService.findAll();
        Product product = IProductService.findById(id);
        model.addAttribute("factories", factories);
        model.addAttribute("product", product);
        return "/product/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("product") Product product, Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        IProductService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/view")
    public String viewProductByParam(@RequestParam("id") String id, Model model) {
        Product product = IProductService.findById(id);
        model.addAttribute("product", product);
        return "/product/view";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Factory> factories = IFactoryNameService.findAll();
        System.out.println(factories.size());
        Product product = new Product();
        product.setFactory(new Factory());
        model.addAttribute("product", product);
        model.addAttribute("factories", factories);
        return "/product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        IProductService.create(product);
        return "redirect:/product/list";
    }

//    @PostMapping("/create2")
//    public String create2(@RequestParam("id") String id,
//                          @RequestParam("name") String name
//                          , RedirectAttributes redirectAttributes
//    ) {
//        Product product = new Product(id, name);
//        service.create(product);
//        System.out.println("Create student success");
//        redirectAttributes.addFlashAttribute("students", service.findAll());
//        return "redirect:/student/list2";
//    }

    @GetMapping(value = "/list")
    public String listPaging(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<Product> products = IProductService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("products", products);
        int totalPages = products.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "product/listPaging";
    }
}
