package com.gmail.sendvi41.controllers;



import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.services.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    @Qualifier("categoryService")
    CategoryServiceInterface categoryServiceInterface;


    @GetMapping("/addcategory")
    public String showAddCategoryPage(Model model) {
       Category category = new Category();
        model.addAttribute("category", category);

        return "categories/add-category";
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryServiceInterface.saveCategory(category);
        return "redirect:/";

    }
}
