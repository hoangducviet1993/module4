package com.codegym.ngay2312.controller;


import com.codegym.ngay2312.model.Category;
import com.codegym.ngay2312.model.Product;
import com.codegym.ngay2312.service.ICategoryService;
import com.codegym.ngay2312.service.IProductService;
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
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public String showList(Model model, String key) {
        Iterable<Product> products;
        if (key != null) {
            products = productService.findByNameContaining(key);

        } else {
            products = productService.findAll();

        }
        model.addAttribute("products", products);
        return "/list";

    }

    @GetMapping("sort")
    public String showListSort(Model model, String key ) {
        Iterable<Product> products;
        if (key != null) {
            products = productService.findByNameContaining(key);

        } else {
            products = productService.findAllByOrderByPrice();

        }
        model.addAttribute("products", products);
        return "/list";

    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "/create";
    }

    @PostMapping("/create")
    public String saveProduct(Model model, Product product ,@RequestParam MultipartFile image1) {
        String fileName = image1.getOriginalFilename();
        try {
            FileCopyUtils.copy(image1.getBytes(), new File("C:\\Users\\vieth\\OneDrive\\Desktop\\baiThucHanh\\module4\\crud2bang-springBoot\\demo1\\src\\main\\resources\\static\\img\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        product.setImage(fileName);
        productService.save(product);
        model.addAttribute("product", new Product());
        model.addAttribute("message", "New product created successfully");
        return "/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product);
            Iterable<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "/edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping("/edit")
    public String updateProduct(Model model, @ModelAttribute("product") Product product) {
        productService.save(product);
        model.addAttribute("product", product);
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("message", "Product updated successfully");
        return "/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(RedirectAttributes redirect, @PathVariable Long id) {
        productService.remove(id);
        redirect.addFlashAttribute("message", "Product deleted successfully");
        return "redirect:/products";
    }

}
