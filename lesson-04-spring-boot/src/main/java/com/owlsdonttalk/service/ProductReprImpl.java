package com.owlsdonttalk.service;

import com.owlsdonttalk.persist.Product;
import com.owlsdonttalk.persist.ProductRepository;
import com.owlsdonttalk.persist.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<ProductRepr> findWithFilter(String productnameFilter) {
        return null;
    }

    @Override
    public Optional<ProductRepr> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void save(ProductRepr product) {
        productRepository.save(new Product(product));
    }

    @Override
    public void delete(long id) {}
}
