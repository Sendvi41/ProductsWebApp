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
        return productRepository.getJoinManFirmCategory();
    }


    @Override
    @Transactional
    public List<CategoryRequestDto> getSortCategories() {
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
             return false;
         }
    }



    @Override
    @Transactional
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public Product getProduct(Long id) throws ServiceResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id "+id)
        );

    }

    @Override
    @Transactional
    public void deleteProduct(Long id) throws ServiceResourceNotFoundException {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ServiceResourceNotFoundException("No such id "+id);
        }

    }

    @Override
    @Transactional
    public void updateProduct(Product product) throws ServiceResourceNotFoundException{
        if(product.getId()!=0) {
            productRepository.save(product);
        }
        else{
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }
}
