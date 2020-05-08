package com.gmail.sendvi41.repositories;


import com.gmail.sendvi41.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product t set t.name = :name, t.category_id = :category_id, t.manFirm_id=:manFirm_id," +
            "t.unit_id=:unit_id, t.unit_price=:unit_price, t.amount=:amount, t.dateTime=:dateTime where t.id = :id")
    void updateProduct(@Param("id") Long id, @Param("name") String name, @Param("category_id") int category_id,
                  @Param("manFirm_id") int manFirm_id, @Param("unit_id") int unit_id, @Param("unit_price") double unit_price,
                  @Param("amount") int amount, @Param("dateTime") Date dateTime);


}



