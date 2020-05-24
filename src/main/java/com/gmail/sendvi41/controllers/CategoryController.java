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
            logger.info("An object with the type category already exists, name " + category.getName());

            model.addAttribute(category);
            logger.info("Transferring object of type category to view");
            return "categories/categoryexsist";
        } else {
            categoryServiceInterface.saveCategory(category);
            logger.info("Successfully save a category type object");
        }


        return "redirect:/listcategories";

    }


    @GetMapping("/editcategory/{id}")
    public String showUpdateFormCategory(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch showUpdateFormCategory");

        try {
            Category category = categoryServiceInterface.getCategory(id);
            logger.info("Category type object found successfully by id" + id);

            model.addAttribute("category", category);
            logger.info("Transferring object of type category to view");

            return "categories/update-category";
        } catch (Exception ex) {
            logger.warn("Object category by identifier" + id + "not found" + ex);
            return "categories/category-deleted";
        }
    }


    @PostMapping("/updatecategory/{id}")
    public String updateCategory(@PathVariable("id") long id, @ModelAttribute("category") Category category,
                                 Model model) {
        logger.info("Successful function launch updateCategory");
        try {
            categoryServiceInterface.getCategory(id);
            logger.info("Category type object found successfully by" + id);

            categoryServiceInterface.saveCategory(category);
            logger.info("Successfully save a category type object");

            return "redirect:/listcategories";
        } catch (Exception ex) {
            logger.warn("Object category by identifier" +id + "not found" +ex);
            return "categories/category-deleted";
        }


    }

    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch deleteCategory");
        try {
            categoryServiceInterface.deleteCategory(id);
            logger.info("Successfully delete a category type object " + id);

            return "redirect:/listcategories";
        } catch (Exception ex) {
            logger.warn("This category type object was not found " + id + " "+ ex );

            return "redirect:/listcategories";
        }

    }

}
