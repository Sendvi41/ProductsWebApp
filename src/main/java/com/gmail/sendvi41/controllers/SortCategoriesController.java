package com.gmail.sendvi41.controllers;

import com.gmail.sendvi41.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SortCategoriesController {


    @Autowired
    @Qualifier("productService")
    ProductServiceInterface productServiceInterface;

    @GetMapping("/sortcategories")
    public String showSortCategoriesPage(Model model) {
        model.addAttribute("categories", productServiceInterface.getSortCategories());

        return "sortcategories/sort_categories";
    }
}
