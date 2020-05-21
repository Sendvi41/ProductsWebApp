package com.gmail.sendvi41.controllers;


import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.services.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {

    @Autowired
    @Qualifier("categoryService")
    CategoryServiceInterface categoryServiceInterface;


    @GetMapping("/listcategories")
    public String showListCategoriesPage(Model model) {
        model.addAttribute("categories", categoryServiceInterface.getCategories());
        return "categories/list-categories";
    }


    @GetMapping("/addcategory")
    public String showAddCategoryPage(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        return "categories/add-category";
    }
    @GetMapping("/test")
    public String test(Model model) {

        return "categories/test";
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {

        if (categoryServiceInterface.findByName(category.getName())) {
            model.addAttribute(category);
            return "categories/categoryexsist";
        } else {
            categoryServiceInterface.saveCategory(category);
        }


        return "redirect:/listcategories";

    }


    @GetMapping("/edit/{id}")
    public String showUpdateFormCategory(@PathVariable("id") long id, Model model) {
        try {
            Category category = categoryServiceInterface.getCategory(id);

            model.addAttribute("category", category);

            return "categories/update-category";
        } catch (Exception ex) {
            return "categories/category-deleted";
        }
    }


    @PostMapping("/update/{id}")
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

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model) {
        try {
            categoryServiceInterface.deleteCategory(id);
            return "redirect:/listcategories";
        } catch (Exception ex) {
            return "redirect:/listcategories";
        }

    }

}
