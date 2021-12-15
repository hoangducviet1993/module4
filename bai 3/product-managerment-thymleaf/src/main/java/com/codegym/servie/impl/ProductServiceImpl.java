package com.codegym.servie.impl;

import com.codegym.model.Product;
import com.codegym.servie.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    List<Product> products;


    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product(1,"Dien thoai", 3500, "Iphone 12", "Apple"));
        products.add(new Product(2,"Dien thoai", 2500, "Iphone 11", "Apple"));
        products.add(new Product(3,"Xe may", 5000, "xe 2 banh", "honda"));
        products.add(new Product(4,"oto", 35000, "xe 4 banh", "toyota"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(findIndexById(id));
    }

    @Override
    public void update(int id, Product product) {
        products.set(findIndexById(id), product);
    }

    @Override
    public void remove(int id) {
        products.remove(findIndexById(id));
    }
}
