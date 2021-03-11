package com.owlsdonttalk.controller;

import com.owlsdonttalk.persist.Product;
import com.owlsdonttalk.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String indexProductPage(Model model,
                                   @RequestParam(name = "nameFilter") Optional<String> nameFilter,
                                   @RequestParam(name = "page") Optional<Integer> page,
                                   @RequestParam(name = "size") Optional<Integer> size) {
        logger.info("Product page update");
        model.addAttribute("products", productService.findWithFilter(nameFilter,
                page, size));
        return "product";
    }

    @GetMapping("/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        logger.info("Edit page for id {} requested", id);

        return "product_form";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        logger.info("Update endpoint requested");

        if (result.hasErrors()) {
            return "product_form";
        }


        logger.info("Updating product with id {}", product.getId());
        productService.save(product);

        return "redirect:/product";
    }

    @GetMapping("/new")
    public String create(Model model) {
        logger.info("Create new product request");

        model.addAttribute("product", new Product());
        return "product_form";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Long id) {
        logger.info("Product delete request");

      //  productService.delete(id);
        return "redirect:/product";
    }

    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException ex) {
        ModelAndView mav = new ModelAndView("not_found");
        mav.setStatus(HttpStatus.NOT_FOUND);
        return mav;
    }
}
