package com.gmail.sendvi41.conversions;

import com.gmail.sendvi41.controllers.ProductController;
import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.services.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

import org.apache.log4j.Logger;

@Service
public class CategoryFormatter implements Formatter<Category> {

    private final Logger logger = Logger.getLogger(CategoryFormatter.class.getName());

    @Autowired
    @Qualifier("categoryService")
    CategoryServiceInterface categoryServiceInterface;

    public CategoryFormatter() {
        super();
    }

    @Override
    public String print(Category object, Locale locale) {
        logger.info("Successful function launch print");
        return (object != null ? object.getId().toString() : "");
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        logger.info("Successful function launch parse");

        Long id = Long.parseLong(text);
        logger.info("ID recognition successful" + id);

        return this.categoryServiceInterface.getCategory(id);//return Type object form DB
    }
}