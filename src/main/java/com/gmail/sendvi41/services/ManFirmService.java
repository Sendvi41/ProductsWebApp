package com.gmail.sendvi41.services;

import com.gmail.sendvi41.entities.ManFirm;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;

import com.gmail.sendvi41.repositories.ManFirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManFirmService implements ManFirmServiceInterface {

    @Autowired
    ManFirmRepository manFirmRepository;


    @Override
    public boolean findByName(String name) {
        if(manFirmRepository.findByName(name)!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    @Override
    @Transactional
    public List<ManFirm> getManFirms() {
        return manFirmRepository.findAll();
    }

    @Override
    @Transactional
    public void saveManFirm(ManFirm manFirm) {
        manFirmRepository.save(manFirm);
    }

    @Override
    @Transactional
    public ManFirm getManFirm(Long id) throws ServiceResourceNotFoundException {
        return manFirmRepository.findById(id).orElseThrow(
                () -> new ServiceResourceNotFoundException("No such id " + id)
        );
    }

    @Override
    @Transactional
    public void deleteManFirm(Long id) throws ServiceResourceNotFoundException {
        if (manFirmRepository.findById(id).isPresent()) {
            manFirmRepository.deleteById(id);
        } else {
            throw new ServiceResourceNotFoundException("No such id " + id);
        }

    }

    @Override
    @Transactional
    public void updateManFirm(ManFirm manFirm) throws ServiceResourceNotFoundException {
        if (manFirm.getId() != 0) {
            manFirmRepository.save(manFirm);
        } else {
            throw new ServiceResourceNotFoundException("Id not specified");
        }
    }
}
