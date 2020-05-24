package com.gmail.sendvi41.services;

import com.gmail.sendvi41.controllers.CategoryController;
import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;
import com.gmail.sendvi41.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.apache.log4j.Logger;

@Service
public class CategoryService implements CategoryServiceInterface {

    private final Logger logger = Logger.getLogger(CategoryService.class.getName());

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public boolean findByName(String name) {
        logger.info("Successful function launch findByName");

        if(categoryRepository.findByName(name)!=null)
        {
            logger.info("Category object was found successfully by name" + name);

            return true;
        }
        else
        {
            logger.info("Category object not found by name" + name);
            return false;
        }
    }

    @Override
    @Transactional
    public List<Category> getCategories() {
        logger.info("Successful function launch getCategories");
       return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        logger.info("Successful function launch saveCategory");

        categoryRepository.save(category);
        logger.info("Successfully save a category type object");
    }

    @Override
    @Transactional
    public Category getCategory(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch getCategory");
        return categoryRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id " + id)
        );
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch deleteCategory");

        if (categoryRepository.findById(id).isPresent()) {
            logger.info("An object of type category was successfully found by id" + id);

            categoryRepository.deleteById(id);
            logger.info("Successfully delete a category type object"+ id);
        } else {
            logger.warn("Category object not found by id" + id);
            throw new ServiceResourceNotFoundException("No such id " + id);
        }

    }

    @Override
    @Transactional
    public void updateCategory(Category category) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch updateCategory");

        if (category.getId() != 0) {
            categoryRepository.save(category);
            logger.info("Successfully save a category type object");

        } else {
            logger.error("Category object has no identifier");
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }

}

