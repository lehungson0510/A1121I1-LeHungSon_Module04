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
import son.codegym.entity.Customer;
import son.codegym.entity.CustomerType;
import son.codegym.service.customer.ICustomerService;
import son.codegym.service.customer_type.ICustomerTypeService;
import son.codegym.validation.ValidationCustomer;

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

    @ModelAttribute("customerTypes")
    List<CustomerType> findAllCustomerType(){
        return customerTypeService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView list(Model model, @RequestParam(defaultValue = "0") int page,
                             @RequestParam("nameSearch") Optional<String> nameSearch,
                             @RequestParam("typeSearch") Optional<String> typeIdSearch,
                             @RequestParam("emailSearch") Optional<String> emailSearch) {
        String nameSearchValue = "";
        String emailSearchValue = "";
        String typeIdSearchValue = "";
        ModelAndView modelAndView = new ModelAndView("customer/list");
        if (nameSearch.isPresent()) {

            nameSearchValue = nameSearch.get();
        }
        if (typeIdSearch.isPresent()) {

            typeIdSearchValue = typeIdSearch.get();
        }
        if (emailSearch.isPresent()) {

            emailSearchValue = emailSearch.get();
        }
        model.addAttribute("nameSearch", nameSearchValue);
        model.addAttribute("typeSearch", typeIdSearchValue);
        model.addAttribute("emailSearch", emailSearchValue);

        Page<Customer> customers = customerService.findAllSearch(nameSearchValue, emailSearchValue, typeIdSearchValue, PageRequest.of(page, 4));

        if(customers.isEmpty()){
            modelAndView.addObject("mess", "Không tìm thấy");
        }
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        Customer customer = new Customer();
        customer.setCustomerTypeId(new CustomerType());
        model.addAttribute("customer", customer);
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        ValidationCustomer validationCustomer = new ValidationCustomer();
        validationCustomer.validate(customer, bindingResult);
        if (customer.getCustomerTypeId() == null) {
            customer.setCustomerTypeId(new CustomerType());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Thêm mới thất bại");
            model.addAttribute("customer", customer);
            return "/customer/create";
        }

        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{customer_id}")
    public String showUpdate(@PathVariable("customer_id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        ValidationCustomer validationCustomer = new ValidationCustomer();
        validationCustomer.validate(customer, bindingResult);
        if (customer.getCustomerTypeId() == null) {
            customer.setCustomerTypeId(new CustomerType());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Cập nhật thất bại");
            model.addAttribute("customer", customer);
            return "/customer/edit";
        }

        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        customerService.update(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        System.out.println(customer.getCustomerId());
        model.addAttribute("customer", customer);
        return "/customer/view";
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView showFormDelete(@PathVariable("id") String id) {
//        List<CustomerType> customerTypes = customerTypeService.findAll();
//        Customer customer = customerService.findById(id);
//        System.out.println(customer.getCustomerId());
//        ModelAndView modelAndView = new ModelAndView("customer/form-delete", "customerTypes", customerTypes);
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") String id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/customer/list";
    }
}
