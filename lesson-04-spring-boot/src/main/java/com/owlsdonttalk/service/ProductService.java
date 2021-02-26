package com.owlsdonttalk.service;

import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductRepr> findAll();

    Page<ProductRepr> findWithFilter(String productnameFilter);

    Optional<ProductRepr> findById(long id);

    void save(ProductRepr user);

    void delete(long id);
}
