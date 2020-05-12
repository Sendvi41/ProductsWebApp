package com.gmail.sendvi41.services;


import com.gmail.sendvi41.entities.ManFirm;
import com.gmail.sendvi41.exceptions.ServiceResourceNotFoundException;

import java.util.List;

public interface ManFirmServiceInterface {

    List<ManFirm> getManFirms();


    void saveManFirm(ManFirm manFirm);

    ManFirm getManFirm(Long id) throws ServiceResourceNotFoundException;

    void deleteManFirm(Long id)  throws ServiceResourceNotFoundException;

    void updateManFirm(ManFirm manFirm)  throws ServiceResourceNotFoundException;

}
