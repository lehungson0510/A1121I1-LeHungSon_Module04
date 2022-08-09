package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import son.codegym.entity.Customer;
import son.codegym.entity.CustomerType;
import son.codegym.repository.ICustomerRepo;
import son.codegym.service.customer.ICustomerService;
import son.codegym.service.customer_type.ICustomerTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public ModelAndView listCustomer(@PageableDefault(value = 5, sort = "customerName", direction = Sort.Direction.DESC) Pageable pageable,
                                     @RequestParam("customerName") Optional<String> customerName,
                                     @RequestParam("customerTypeId") Optional<Integer> customerTypeId,
                                     @RequestParam("customerEmail") Optional<String> customerEmail) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Page<Customer> customerList;
        String condition = "";
        ModelAndView modelAndView = new ModelAndView("customer/list");
        if (customerName.isPresent() || customerTypeId.isPresent() || customerEmail.isPresent()) {
            customerList = customerService.search(customerName.get(), customerEmail.get(), customerTypeId.get(), pageable);
            if (customerList.isEmpty()){
                modelAndView.addObject("mess", "Không tìm thấy");
            }
            if (customerName.isPresent()) {
                condition += "&customerName=" + customerName.get();
            }
            if (customerName.isPresent()) {
                condition += "&customerTypeId=" + customerTypeId.get();
            }
            if (customerName.isPresent()) {
                condition += "&customerEmail=" + customerEmail.get();
            }
        } else {
            customerList = customerService.findAllWithPaging(pageable);
        }
        modelAndView.addObject("customerTypes", customerTypes);
        modelAndView.addObject("condition", condition);
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Customer customer = new Customer();
        customer.setCustomerTypeId(new CustomerType());
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", customerTypes);
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{customer_id}")
    public String showFormUpdateProduct(@PathVariable("customer_id") String id, Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Customer customer = customerService.findById(id);
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customer", customer);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("customer") Customer customer, Model model, RedirectAttributes redirectAttributes) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        customerService.update(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/view/{id}")
    public String viewProductByParam(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/view";
    }
}
