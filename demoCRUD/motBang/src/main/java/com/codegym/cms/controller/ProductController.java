package com.codegym.cms.controller;

import com.codegym.cms.model.Product;
import com.codegym.cms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model){
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }
}
