package com.gmail.sendvi41.repositories;


import com.gmail.sendvi41.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository   extends JpaRepository<Unit, Long> {
}
