package com.gmail.sendvi41.conversions;



import com.gmail.sendvi41.entities.ManFirm;
import com.gmail.sendvi41.services.ManFirmServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

import org.apache.log4j.Logger;

@Service
public class ManFirmFormatter implements Formatter<ManFirm> {

    private final Logger logger = Logger.getLogger(ManFirmFormatter.class.getName());

    @Autowired
    @Qualifier("manFirmService")
    ManFirmServiceInterface manFirmServiceInterface;

    public  ManFirmFormatter() {
        super();
    }


    @Override
    public String print(ManFirm object, Locale locale) {
        logger.info("Successful function launch print");
        return (object != null ? object.getId().toString() : "");
    }

    @Override
    public ManFirm parse(String text, Locale locale) throws ParseException {
        logger.info("Successful function launch parse");

        Long id = Long.parseLong(text);
        logger.info("ID recognition successful" + id);
        return this.manFirmServiceInterface.getManFirm(id);//return Type object form DB
    }
}

