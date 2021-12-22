package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/create-product")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create-product")
    public String saveProduct(Model model, @ModelAttribute("product") Product product ,@RequestParam MultipartFile image) {
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File("D:\\image2\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        productService.save(product);
        model.addAttribute("product", new Product());
        model.addAttribute("message", "New product created successfully");
        return "/create";
    }

    @GetMapping("/edit-product/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product);
            return "/edit";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/edit-product")
    public String updateProduct(Model model, @ModelAttribute("product") Product product) {
        productService.save(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Product updated successfully");
        return "/edit";
    }

    @GetMapping("/delete-product/{id}")
    public String showDeleteForm(Model model, @PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product);
            return "/delete";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(RedirectAttributes redirect, @ModelAttribute("product") Product product) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/products";
    }
}
