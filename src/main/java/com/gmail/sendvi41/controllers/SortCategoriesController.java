package com.gmail.sendvi41.controllers;

import com.gmail.sendvi41.dto.CategoryRequestDto;
import com.gmail.sendvi41.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.log4j.Logger;


@Controller
public class SortCategoriesController {

    private final Logger logger = Logger.getLogger(SortCategoriesController.class.getName());

    @Autowired
    @Qualifier("productService")
    ProductServiceInterface productServiceInterface;

    @GetMapping("/sortcategories")
    public String showSortCategoriesPage(Model model) {
        logger.info("Successful function launch showSortCategoriesPage");

        model.addAttribute("categories", productServiceInterface.getSortCategories());
        logger.info("Getting all objects of type CategoryRequestDto and transferring objects to view");

        return "sortcategories/sort_categories";
    }
}
