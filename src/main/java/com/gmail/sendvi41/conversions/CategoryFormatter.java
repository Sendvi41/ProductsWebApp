package com.gmail.sendvi41.conversions;

import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.services.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class CategoryFormatter implements Formatter<Category> {

    @Autowired
    @Qualifier("categoryService")
    CategoryServiceInterface categoryServiceInterface;

    public CategoryFormatter() {
        super();
    }

    @Override
    public String print(Category object, Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Long id = Long.parseLong(text);
        return this.categoryServiceInterface.getCategory(id);//return Type object form DB
    }
}