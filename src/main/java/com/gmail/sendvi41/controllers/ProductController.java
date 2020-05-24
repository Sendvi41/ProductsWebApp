package com.gmail.sendvi41.controllers;



import com.gmail.sendvi41.entities.Product;
import com.gmail.sendvi41.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sun.rmi.runtime.Log;


import java.util.List;
import org.apache.log4j.Logger;

@Controller
//@RequestMapping("/products")
public class ProductController {

    private final Logger logger = Logger.getLogger(ProductController.class.getName());

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
        logger.info("Successful function launch showListProducts");

        List<Product> products = productServiceInterface.getProducts();
        logger.info("Getting all objects of type products");

        theModel.addAttribute("products", products);
        logger.info("Transferring objects of type product to view");

        return "products/list-products";
    }

    @GetMapping("/addproduct")
    public String showAddProductPage(Model model) {
        logger.info("Successful function launch showAddProductPage");

        Product product = new Product();
        logger.info("Product type object created");

        model.addAttribute("product", product);
        logger.info("Transferring object of type product to view");


        model.addAttribute("categories", categoryServiceInterface.getCategories());
        logger.info("Getting all objects of type category and transferring objects to view");

        model.addAttribute("manfirms", manFirmServiceInterface.getManFirms());
        logger.info("Getting all objects of type manfirm and transferring objects to view");

        model.addAttribute("units", unitServiceInterface.getUnits());
        logger.info("Getting all objects of type unit and transferring objects to view");

        return "products/add-product";
    }

    @PostMapping("/saveproduct")
    public String saveProduct(@ModelAttribute("product") Product product, Model model) {
        logger.info("Successful function launch saveProduct");

        if (productServiceInterface.findByName(product.getName())) {
            logger.info("An object with the type product already exists, name " + product.getName());

            model.addAttribute(product);
            logger.info("Transferring object of type product to view");

            return "products/productexsist";
        } else {
            productServiceInterface.saveProduct(product);
            logger.info("Successfully save a product type object");
        }

        return "redirect:/";
    }


    @GetMapping("/editproduct/{id}")
    public String showUpdateFormProduct(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch showUpdateFormProduct");

        try {
            Product product = productServiceInterface.getProduct(id);
            logger.info("Product type object found successfully by id" + id);

            model.addAttribute("categorie", categoryServiceInterface.getCategories());
            logger.info("Getting all objects of type category and transferring objects to view");

            model.addAttribute("manfirm", manFirmServiceInterface.getManFirms());
            logger.info("Getting all objects of type manfirm and transferring objects to view");

            model.addAttribute("unit", unitServiceInterface.getUnits());
            logger.info("Getting all objects of type unit and transferring objects to view");

            model.addAttribute("product", product);
            logger.info("Transferring object of type product to view");

            return "products/update-product";
        } catch (Exception ex) {
            logger.warn("Object product by identifier" + id + "not found" + ex);
            return "products/product-deleted";
        }
    }


    @PostMapping("/updateproduct/{id}")
    public String updateProduct(@PathVariable("id") long id, @ModelAttribute("category") Product product,
                                 Model model) {
        logger.info("Successful function launch updateProduct");
        try {
            productServiceInterface.getProduct(id);
            logger.info("Product type object found successfully by" + id);

            productServiceInterface.saveProduct(product);
            logger.info("Successfully save a product type object");

            return "redirect:/";
        } catch (Exception ex) {
            logger.warn("Object product by identifier" + id + "not found" +ex);
            return "products/product-deleted";
        }


    }

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch deleteProduct");

        try {
            productServiceInterface.deleteProduct(id);
            logger.info("Successfully delete a product type object " + id);

            return "redirect:/";
        } catch (Exception ex) {
            logger.warn("This product type object was not found " + id + " "+ ex );
            return "redirect:/";
        }

    }




}
