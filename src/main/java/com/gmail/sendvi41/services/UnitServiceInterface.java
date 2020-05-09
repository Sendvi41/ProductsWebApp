package com.gmail.sendvi41.services;


import com.gmail.sendvi41.entities.Unit;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;

import java.util.List;

public interface UnitServiceInterface {

    List<Unit> getUnit();

    void saveUnit(Unit unit);

    Unit getUnit(Long id) throws ServiceResourceNotFoundException;

    void deleteUnit(Long id)  throws ServiceResourceNotFoundException;

    void updateUnit(Unit unit)  throws ServiceResourceNotFoundException;



}
