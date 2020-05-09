package com.gmail.sendvi41.services;


import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;

import java.util.List;

public interface CategoryServiceInterface {

    List<Category> getCategories();

    void saveCategory(Category category);

    Category getCategory(Long id) throws ServiceResourceNotFoundException;

    void deleteCategory(Long id)  throws ServiceResourceNotFoundException;

    void updateCategory(Category category)  throws ServiceResourceNotFoundException;
}
