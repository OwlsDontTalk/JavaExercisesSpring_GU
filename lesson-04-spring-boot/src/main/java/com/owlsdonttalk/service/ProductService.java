package com.owlsdonttalk.service;


import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductRepr> findAll();

    List<ProductRepr> findWithFilter(String name);

    Optional<ProductRepr> findById(long id);

    void save(ProductRepr user);

    void delete(long id);
}
