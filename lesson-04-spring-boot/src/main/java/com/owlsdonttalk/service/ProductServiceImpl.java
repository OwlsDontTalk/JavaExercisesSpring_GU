package com.owlsdonttalk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.owlsdonttalk.persist.Product;
import com.owlsdonttalk.persist.ProductRepository;
import com.owlsdonttalk.persist.ProductSpecification;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findWithFilter(Optional<String> nameFilter,
                                        Optional<Integer> page,
                                        Optional<Integer> size) {
        Specification<Product> spec = Specification.where(null);
        if (nameFilter.isPresent() && !nameFilter.get().isBlank()) {
            logger.info("Adding {} to filter", nameFilter.get());
            spec = spec.and(ProductSpecification.nameLike(nameFilter.get()));
        }

        return productRepository.findAll(spec, PageRequest.of(page.orElse(1) - 1, size.orElse(5)));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}

