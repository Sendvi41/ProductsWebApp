package com.gmail.sendvi41.repositories;


import com.gmail.sendvi41.entities.ManFirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManFirmRepository   extends JpaRepository<ManFirm, Long> {

    @Query("select c from ManFirm c where c.name = :name")
    ManFirm findByName(@Param("name") String name);
}
