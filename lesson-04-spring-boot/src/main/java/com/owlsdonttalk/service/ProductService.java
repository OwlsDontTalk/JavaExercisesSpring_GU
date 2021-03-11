package com.owlsdonttalk.service;


import com.owlsdonttalk.persist.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Page<Product> findWithFilter(Optional<String> nameFilter,
                                    Optional<Integer> page,
                                 Optional<Integer> size);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);
}