package com.gmail.sendvi41.services;

import com.gmail.sendvi41.entities.Product;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;
import com.gmail.sendvi41.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;


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
        return productRepository.findById(id).orElseThrow(() -> new ServiceResourceNotFoundException("No such id "+id)
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
