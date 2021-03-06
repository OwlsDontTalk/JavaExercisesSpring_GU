package com.owlsdonttalk.persist;

import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecification {

    public static Specification<User> usernameLike(String name) {
        return (root, query, cb) -> cb.like(root.get("name"), "%" + name + "%");
    }
}
