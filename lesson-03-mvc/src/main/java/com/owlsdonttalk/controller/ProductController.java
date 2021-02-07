package com.owlsdonttalk.controller;

import com.owlsdonttalk.persist.Product;
import com.owlsdonttalk.persist.ProductRepository;
import com.owlsdonttalk.persist.User;
import com.owlsdonttalk.persist.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        logger.info("Edit page for id {} requested", id);

        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @PostMapping("/update")
    public String update(Product product) {
        logger.info("Update endpoint requested");

        if (product.getId() != -1) {
            productRepository.update(product);
        } else {
            productRepository.insert(product);
        }
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String createProduct(){
        return ("product_form_add");
    }

    @PostMapping("/new/add")
    public String createProductProcessor(@RequestParam("name") String name){
        this.productRepository.insert(new Product(name));
        return ("redirect:/product");
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") Long id) {

        logger.info("Removing product with id {}", id);
        this.productRepository.delete(id);
        return "redirect:/product";
    }

}
