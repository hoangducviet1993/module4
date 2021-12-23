package com.codegym.ngay2312.service;

import com.codegym.ngay2312.model.Product;


public interface IProductService extends IGeneralService<Product>{
    Iterable<Product> findByNameContaining(String name );
    Iterable<Product> findAllByOrderByPrice();
}
