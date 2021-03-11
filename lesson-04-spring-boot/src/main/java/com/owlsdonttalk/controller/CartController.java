package com.owlsdonttalk.controller;

import com.owlsdonttalk.persist.User;
import com.owlsdonttalk.service.CartService;
import com.owlsdonttalk.service.LineItem;
import com.owlsdonttalk.service.UserRepr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    private final CartService cartService;


    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping
    public String listPage(Model model) {
        logger.info("Cart page requested");

        List<LineItem> items = cartService.findAllItemsForUser(1L);
        model.addAttribute("items", items );
        return "cart";
    }

    @PostMapping("/add")
    public void addToCart(){
        logger.info("i don't belive it");
    }

}
