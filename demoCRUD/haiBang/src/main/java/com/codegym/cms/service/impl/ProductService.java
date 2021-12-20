package com.codegym.cms.service.impl;

import com.codegym.cms.model.Product;
import com.codegym.cms.repository.IProductRepository;
import com.codegym.cms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
    productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);

    }

//    @Override
//    public Iterable<Product> findByNameContaining(String name) {
//        return productRepository.findByNameContaining(name);
//    }

    @Override
    public Iterable<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    @Override
    public Iterable<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByPrice() {
        return productRepository.findAllByOrderByPrice();
    }
}
