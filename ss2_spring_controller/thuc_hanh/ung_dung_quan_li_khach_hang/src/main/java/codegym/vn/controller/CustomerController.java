package codegym.vn.controller;

import codegym.vn.entity.Customer;
import codegym.vn.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // setter injection: cách triển khai ngắn gọn, hay dùng
    @Autowired
//    @Qualifier("studentServiceImpl")
    private ICustomerService customerService;
    // triển khai setter injection đầy đủ
//    @Autowired
//    @Qualifier("studentService1")
//    public void setService(StudentService service) {
//        this.service = service;
//    }

    @GetMapping(value = "/list")
    public String list(Model model) {
        List<Customer> customer = customerService.findAll();
        model.addAttribute("customer", customer);
        return "customer/list";
    }

    @GetMapping("/view/{customer_id}")
    public String viewStudent(@PathVariable("customer_id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/view";
    }

//    // Dùng formatter
//    @GetMapping("/view/{customer_id}")
//    public String viewStudent(@PathVariable("customer_id") Customer customer, Model model) {
//        model.addAttribute("student", customer);
//        return "/customer/view";
//    }

//    @GetMapping("/view")
//    public String viewStudentByParam(@RequestParam("id") String id, Model model) {
//        Customer customer = customerService.findById(id);
//        model.addAttribute("student", customer);
//        return "/customer/view";
//    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create2(@RequestParam("id") String id,
                          @RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("address") String address
            , Model model
    ) {
        Customer student = new Customer(id, name, email, address);
        customerService.create(student);
        System.out.println("Create student success");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{customer_id}")
    public String deleteStudent(@PathVariable("customer_id") String id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }

}
