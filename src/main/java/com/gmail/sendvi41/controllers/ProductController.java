package com.gmail.sendvi41.controllers;


import com.gmail.sendvi41.entities.Product;
import com.gmail.sendvi41.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceInterface productServiceInterface;

    @GetMapping("/")
    public  String showListProducts(Model theModel){
        List <Product> products = productServiceInterface.getProducts();
        theModel.addAttribute("products", products);
        return "products/list-products";
    }



}
