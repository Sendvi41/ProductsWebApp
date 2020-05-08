package com.gmail.sendvi41.repositories;

import com.gmail.sendvi41.entities.ManFirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManFirmRepository   extends JpaRepository<ManFirm, Long> {
}
