package com.gmail.sendvi41.services;


import com.gmail.sendvi41.entities.Unit;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;
import com.gmail.sendvi41.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnitService implements UnitServiceInterface{

    @Autowired
    UnitRepository unitRepository;

    @Override
    @Transactional
    public List<Unit> getUnits() {
        return unitRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUnit(Unit unit) {
        unitRepository.save(unit);
    }

    @Override
    @Transactional
    public Unit getUnit(Long id) throws ServiceResourceNotFoundException {
        return unitRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id "+id)
        );
    }

    @Override
    @Transactional
    public void deleteUnit(Long id) throws ServiceResourceNotFoundException {
        if (unitRepository.findById(id).isPresent()) {
            unitRepository.deleteById(id);
        } else {
            throw new ServiceResourceNotFoundException("No such id "+id);
        }

    }

    @Override
    @Transactional
    public void updateUnit(Unit unit) throws ServiceResourceNotFoundException {
        if(unit.getId()!=0) {
            unitRepository.save(unit);
        }
        else{
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }
}
