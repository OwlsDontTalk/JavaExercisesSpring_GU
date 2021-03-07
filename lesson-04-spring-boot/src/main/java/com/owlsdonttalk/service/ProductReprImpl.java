package com.owlsdonttalk.service;

import com.owlsdonttalk.persist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductReprImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductReprImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductRepr> findAll() {
        return productRepository.findAll()
                .stream().map(ProductRepr::new).collect(Collectors.toList());
    }

    @Override
    public Page<ProductRepr> findWithFilter(String name, Integer page, Integer size) {
        Specification<Product> spec = Specification.where(null);
        if (name != null && !name.isBlank()) {
            spec = spec.and(ProductSpecification.nameLike(name));
        }
        return productRepository.findAll(spec, PageRequest.of(page, size)).map(ProductRepr::new);
    }

    @Override
    public Optional<ProductRepr> findById(long id) {
        return productRepository.findById(id)
                .map(ProductRepr::new);
    }

    @Override
    public void save(ProductRepr product) {
        productRepository.save(new Product(product));
    }

    @Override
    public void delete(long id) {}
}
