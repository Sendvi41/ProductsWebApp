package com.gmail.sendvi41.repositories;


import com.gmail.sendvi41.dto.ManFirmRequestDto;
import com.gmail.sendvi41.entities.Product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("select p from Product p where p.name = :name")
    Product findByName(@Param("name") String name);


    @Query("select new com.gmail.sendvi41.dto.ManFirmRequestDto(p.manFirm_id.name,(select sum(p2.amount) from Product p2 group by p2.manFirm_id.name " +
            "having p2.manFirm_id.name= p.manFirm_id.name), p.category_id.name, sum(p.amount)) " +
            "from Product p " +
            "group by p.manFirm_id.name, p.category_id.name " +
            "order by  p.manFirm_id.name")
    List<ManFirmRequestDto> getJoinManFirmCategory();
}
//    select sum(p2.amount) from Product  group by p2.manFirm_id.name\n" +
//        "                         having p2.manFirm_id.name=p.manFirm_id.name)