package com.codegym.ngay2312.repository;


import com.codegym.ngay2312.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findByNameContaining(String name );
    Iterable<Product> findAllByOrderByPrice();

}
