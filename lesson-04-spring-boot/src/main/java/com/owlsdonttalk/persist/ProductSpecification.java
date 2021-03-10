package com.owlsdonttalk.persist;

import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecification {

    public static Specification<Product> nameLike(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

}
