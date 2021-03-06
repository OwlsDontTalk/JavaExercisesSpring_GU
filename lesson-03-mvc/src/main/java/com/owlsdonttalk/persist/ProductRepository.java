package com.owlsdonttalk.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new Product("product1"));
        this.insert(new Product("product2"));
        this.insert(new Product("product3"));
    }

    public void insert(Product product){
        long id0 = this.id.incrementAndGet();
        product.setId(id0);
        this.productMap.put(id0, product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Product findById(long id) {
        return productMap.get(id);
    }

    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    public void delete(long id) {
        productMap.remove(id);
    }
}

