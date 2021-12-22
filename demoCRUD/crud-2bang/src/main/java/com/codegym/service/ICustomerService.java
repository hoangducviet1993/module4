package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IGeneralService<Customer>{
    Page<Customer> findByFirstNameContaining(String firstName, Pageable pageable);
//    Iterable<Customer> findAllByOrderByProvince(Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
}
