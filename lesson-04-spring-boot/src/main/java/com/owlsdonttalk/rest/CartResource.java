package com.owlsdonttalk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * Добавление товара в каризу пользователя
 * Удаление товара из корзины пользователя
 *
 */


@RestController
@RequestMapping("/api/v1/cart")
public class CartResource {

//    private final CartService cartService;

    @Autowired
//    public CartResource(CartService cartService) {
//        this.cartService = cartService;
//    }

    public void addProductForUser() {
    }

    public void findItemsForUser() {
    }

    public void removeProductForUser() {

    }
}
