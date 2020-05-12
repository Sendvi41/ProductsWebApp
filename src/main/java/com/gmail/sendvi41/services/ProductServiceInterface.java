package com.gmail.sendvi41.services;

import com.gmail.sendvi41.dto.ManFirmRequestDto;
import com.gmail.sendvi41.entities.Product;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;

import java.util.List;

public interface ProductServiceInterface {
    List <Product> getProducts();

    void saveProduct(Product product);

    List<ManFirmRequestDto> getJoinManFirmCategory();

    public boolean findByName (String name);

    Product getProduct(Long id) throws ServiceResourceNotFoundException ;

    void deleteProduct(Long id)  throws ServiceResourceNotFoundException;

    void updateProduct(Product product)  throws ServiceResourceNotFoundException;


}
