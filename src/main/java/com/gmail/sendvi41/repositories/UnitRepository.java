package com.gmail.sendvi41.repositories;


import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository   extends JpaRepository<Unit, Long> {
    @Query("select c from Unit c where c.name = :name")
    Unit findByName(@Param("name") String name);

}
