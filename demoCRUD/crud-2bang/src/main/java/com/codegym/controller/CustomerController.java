package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.model.Upload;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    private Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
//        Iterable<Province> provinces = provinceService.findAll();
//        model.addAttribute("provinces", provinces);
        return "/customer/create";
    }

    @PostMapping("create")
    public String saveCreateForm(Model model, @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "New Customer created successfully");
        return "/customer/create";
    }

    @GetMapping("")
    public String showList(Model model,@RequestParam("search") Optional<String> search, @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findByFirstNameContaining(search.get(),pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        model.addAttribute("customers", customers);
        return "/customer/list";
    }

//    @GetMapping("sort")
//    public String showSortList(Model model, Pageable pageable, String key) {
//        Iterable<Customer> customers;
//        if (key != null) {
//            customers = customerService.findByFirstNameContaining(key, pageable);
//        } else {
//            customers = customerService.findAllByOrderByProvince(pageable);
//        }
//        model.addAttribute("customers", customers);
//        return "/customer/list";
//    }

    @GetMapping("edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer);
            return "/customer/edit";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("edit")
    public String updateCustomer(Model model, @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("message", "Product updated successfully");
        return "/customer/edit";
    }

    @GetMapping("delete/{id}")
    public String deleteCustomer(RedirectAttributes redirectAttributes, @PathVariable Long id) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully");
        return "redirect:/customers";
    }
    @GetMapping("upload")
    private String uploadFile(Model model){
        model.addAttribute("upload", new Upload());
        return "/uploadFile";
    }

}
