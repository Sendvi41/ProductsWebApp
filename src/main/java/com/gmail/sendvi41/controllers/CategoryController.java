package com.gmail.sendvi41.controllers;


import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.services.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@Controller
public class CategoryController {

    private final Logger logger = Logger.getLogger(CategoryController.class.getName());

    @Autowired
    @Qualifier("categoryService")
    CategoryServiceInterface categoryServiceInterface;


    @GetMapping("/listcategories")
    public String showListCategoriesPage(Model model) {
        logger.info("Successful function launch showListCategoriesPage");

        model.addAttribute("categories", categoryServiceInterface.getCategories());
        logger.info("Getting all objects of type category and transferring objects to view");

        return "categories/list-categories";
    }


    @GetMapping("/addcategory")
    public String showAddCategoryPage(Model model) {
        logger.info("Successful function launch showAddCategoryPage");

        Category category = new Category();
        logger.info("Category type object created");

        model.addAttribute("category", category);
        logger.info("Transferring object of type category to view");

        return "categories/add-category";
    }


    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {
        logger.info("Successful function launch saveCategory");

        if (categoryServiceInterface.findByName(category.getName())) {
            model.addAttribute(category);
            logger.info("Transferring object of type category to view");
            return "categories/categoryexsist";
        } else {
            categoryServiceInterface.saveCategory(category);
        }


        return "redirect:/listcategories";

    }


    @GetMapping("/editcategory/{id}")
    public String showUpdateFormCategory(@PathVariable("id") long id, Model model) {
        try {
            Category category = categoryServiceInterface.getCategory(id);

            model.addAttribute("category", category);

            return "categories/update-category";
        } catch (Exception ex) {
            return "categories/category-deleted";
        }
    }


    @PostMapping("/updatecategory/{id}")
    public String updateCategory(@PathVariable("id") long id, @ModelAttribute("category") Category category,
                                 Model model) {
        try {
            categoryServiceInterface.getCategory(id);
            categoryServiceInterface.saveCategory(category);
            return "redirect:/listcategories";
        } catch (Exception ex) {
            return "categories/category-deleted";
        }


    }

    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model) {
        try {
            categoryServiceInterface.deleteCategory(id);
            return "redirect:/listcategories";
        } catch (Exception ex) {
            return "redirect:/listcategories";
        }

    }

}
