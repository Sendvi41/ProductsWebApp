package com.gmail.sendvi41.services;

import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;
import com.gmail.sendvi41.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    @Transactional
    public List<Category> getCategories() {
       return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category getCategory(Long id) throws ServiceResourceNotFoundException {
        return categoryRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id " + id)
        );
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) throws ServiceResourceNotFoundException {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new ServiceResourceNotFoundException("No such id " + id);
        }

    }

    @Override
    @Transactional
    public void updateCategory(Category category) throws ServiceResourceNotFoundException {
        if (category.getId() != 0) {
            categoryRepository.save(category);
        } else {
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }

}

