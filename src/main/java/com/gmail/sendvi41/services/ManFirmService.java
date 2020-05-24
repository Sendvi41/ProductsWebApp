package com.gmail.sendvi41.services;

import com.gmail.sendvi41.entities.ManFirm;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;

import com.gmail.sendvi41.repositories.ManFirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import java.util.List;

@Service
public class ManFirmService implements ManFirmServiceInterface {

    private final Logger logger = Logger.getLogger(ManFirmService.class.getName());

    @Autowired
    ManFirmRepository manFirmRepository;


    @Override
    public boolean findByName(String name) {
        logger.info("Successful function launch findByName");
        if(manFirmRepository.findByName(name)!=null)
        {
            logger.info("ManFirm object was found successfully by name" + name);
            return true;
        }
        else
        {
            logger.info("ManFirm object not found by name" + name);
            return false;
        }
    }


    @Override
    @Transactional
    public List<ManFirm> getManFirms() {
        logger.info("Successful function launch getManFirms");
        return manFirmRepository.findAll();
    }

    @Override
    @Transactional
    public void saveManFirm(ManFirm manFirm) {
        logger.info("Successful function launch saveManFirm");

        manFirmRepository.save(manFirm);
        logger.info("Successfully save a manFirm type object");
    }

    @Override
    @Transactional
    public ManFirm getManFirm(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch getManFirm");
        return manFirmRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id " + id)
        );
    }

    @Override
    @Transactional
    public void deleteManFirm(Long id) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch deleteManFirm");

        if (manFirmRepository.findById(id).isPresent()) {
            logger.info("An object of type manfirm was successfully found by id" + id);

            manFirmRepository.deleteById(id);
            logger.info("Successfully delete a manfirm type object"+ id);
        } else {
            logger.warn("ManFirm object not found by id" + id);
            throw new ServiceResourceNotFoundException("No such id " + id);
        }

    }

    @Override
    @Transactional
    public void updateManFirm(ManFirm manFirm) throws ServiceResourceNotFoundException {
        logger.info("Successful function launch updateManFirm");

        if (manFirm.getId() != 0) {
            manFirmRepository.save(manFirm);
            logger.info("Successfully save a manFirm type object");
        } else {
            logger.error("Manfirm object has no identifier");
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }
}
