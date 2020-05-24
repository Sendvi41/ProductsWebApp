package com.gmail.sendvi41.services;


import com.gmail.sendvi41.entities.Unit;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;
import com.gmail.sendvi41.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import java.util.List;

@Service
public class UnitService implements UnitServiceInterface{

    private final Logger logger = Logger.getLogger(UnitService.class.getName());

    @Autowired
    UnitRepository unitRepository;



    @Override
    public boolean findByName(String name) {
        logger.info("Successful function launch findByName");
        if(unitRepository.findByName(name)!=null)
        {
            logger.info("Unit object was found successfully by name" + name);
            return true;
        }
        else
        {
            logger.info("Unit object not found by name" + name);
            return false;
        }
    }

    @Override
    @Transactional
    public List<Unit> getUnits() {
        logger.info("Successful function launch getUnits");
        return unitRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUnit(Unit unit) {
        logger.info("Successful function launch saveUnit");

        unitRepository.save(unit);
        logger.info("Successfully save a unit type object");
    }

    @Override
    @Transactional
    public Unit getUnit(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch getUnit");
        return unitRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id "+id)
        );
    }

    @Override
    @Transactional
    public void deleteUnit(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch deleteUnit");

        if (unitRepository.findById(id).isPresent()) {
            logger.info("An object of type unit was successfully found by id" + id);

            unitRepository.deleteById(id);
            logger.info("Successfully delete a unit type object"+ id);
        } else {
            logger.warn("Unit object not found by id" + id);
            throw new ServiceResourceNotFoundException("No such id "+id);
        }

    }

    @Override
    @Transactional
    public void updateUnit(Unit unit) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch updateUnit");
        if(unit.getId()!=0) {
            unitRepository.save(unit);
            logger.info("Successfully save a unit type object");
        }
        else{
            logger.error("Unit object has no identifier");
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }
}
