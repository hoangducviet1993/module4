package com.codegym.cms.service;

import com.codegym.cms.model.Product;
import org.springframework.data.domain.Sort;

public interface IProductService extends IGeneralService<Product>{
        Iterable<Product> findAll(Sort sort);
    Iterable<Product> findByNameContaining(String name );
    Iterable<Product> findAllByOrderByPrice();
}
