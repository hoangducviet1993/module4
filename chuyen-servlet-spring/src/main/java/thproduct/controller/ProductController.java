package thproduct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thproduct.model.Category;
import thproduct.model.Product;
import thproduct.service.CategoryService;
import thproduct.service.impl.CategoryServiceImpl;
import thproduct.service.impl.ProductServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    @GetMapping("/")
    public String greeting() {
        return "index";
    }
    @GetMapping("/products")
    public String showList( Model model , @RequestParam(defaultValue = "") String key) throws SQLException {
//        String key = request.getParameter("key");
        List<Product> products = new ArrayList<>();
        if (key == "") {
            products = productService.findAll();
        } else {
            products = productService.findByName(key);
            if (products.size() == 0) {
                products = productService.findAll();
            }
        }
        model.addAttribute("product", products);
        List<Category> categories = findALlCategory(products);
        model.addAttribute("category", categories);
        return "list";
    }
    private List<Category> findALlCategory(List<Product> products) throws SQLException {
        List<Category> list = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Category category = categoryService.findById(products.get(i).getCategoryId());
            list.add(category);
        }
        return  list;
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) throws SQLException {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "create";
    }
    @PostMapping ("/create")
    public String  createProduct(Model model,
                                 @RequestParam String name,
                                 @RequestParam int price,
                                 @RequestParam int quantity,
                                 @RequestParam String color,
                                 @RequestParam int categoryId
                                 ) throws SQLException {
        productService.save( new Product(name,price,quantity,color,categoryId));
//        model.addAttribute("categories", categories);
        return "create";
    }
}
