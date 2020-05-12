package com.gmail.sendvi41.controllers;


import com.gmail.sendvi41.entities.Product;
import com.gmail.sendvi41.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {


    @Autowired
    @Qualifier("productService")
    ProductServiceInterface productServiceInterface;

    @Autowired
    @Qualifier("categoryService")
    CategoryServiceInterface categoryServiceInterface;

    @Autowired
    @Qualifier("manFirmService")
    ManFirmServiceInterface manFirmServiceInterface;

    @Autowired
    @Qualifier("unitService")
    UnitServiceInterface unitServiceInterface;

    @GetMapping("/")
    public String showListProducts(Model theModel) {
        List<Product> products = productServiceInterface.getProducts();
        theModel.addAttribute("products", products);
        return "products/list-products";
    }

    @GetMapping("/addproduct")
    public String showAddProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryServiceInterface.getCategories());
        model.addAttribute("manfirms", manFirmServiceInterface.getManFirms());
        model.addAttribute("units", unitServiceInterface.getUnits());
        return "products/add-product";
    }

    @PostMapping("/saveproduct")
    public String saveProduct(@ModelAttribute("product") Product product, Model model) {

        if (productServiceInterface.findByName(product.getName())) {
            model.addAttribute(product);
            return "products/productexsist";
        } else {
            productServiceInterface.saveProduct(product);
        }


        return "redirect:/";

    }


}
