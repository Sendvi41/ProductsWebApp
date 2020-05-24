package com.gmail.sendvi41.services;

import com.gmail.sendvi41.dto.CategoryRequestDto;
import com.gmail.sendvi41.dto.ManFirmRequestDto;
import com.gmail.sendvi41.entities.Product;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;
import com.gmail.sendvi41.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    private final Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    ProductRepository productRepository;


    @Override
    @Transactional
    public List<ManFirmRequestDto> getJoinManFirmCategory() {
        logger.info("Successful function launch getJoinManFirmCategory");

        return productRepository.getJoinManFirmCategory();
    }


    @Override
    @Transactional
    public List<CategoryRequestDto> getSortCategories() {
        logger.info("Successful function launch getSortCategories");

        return  productRepository.getSortCategories();
    }

    @Override
    @Transactional
    public boolean findByName (String name) {
        logger.info("Successful function launch findByName");
         if(productRepository.findByName(name)!=null)
         {
             logger.info("Product object was found successfully by name" + name);
             return true;
         }
         else
         {
             logger.info("Product object not found by name" + name);
             return false;
         }
    }



    @Override
    @Transactional
    public List<Product> getProducts() {
        logger.info("Successful function launch getProducts");

        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        logger.info("Successful function launch saveProduct");

        productRepository.save(product);
        logger.info("Successfully save a product type object");
    }

    @Override
    @Transactional
    public Product getProduct(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch getProduct");

        return productRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id "+id)
        );

    }

    @Override
    @Transactional
    public void deleteProduct(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch deleteProduct");

        if (productRepository.findById(id).isPresent()) {
            logger.info("An object of type product was successfully found by id" + id);

            productRepository.deleteById(id);
            logger.info("Successfully delete a product type object"+ id);

        } else {
            logger.warn("Product object not found by id" + id);
            throw new ServiceResourceNotFoundException("No such id "+id);
        }

    }

    @Override
    @Transactional
    public void updateProduct(Product product) throws ServiceResourceNotFoundException{
        logger.info("Successful function launch updateProduct");

        if(product.getId()!=0) {
            productRepository.save(product);
            logger.info("Successfully save a product type object");
        }
        else{
            logger.error("Product object has no identifier");
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }
}
