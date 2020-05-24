package com.gmail.sendvi41.conversions;



import com.gmail.sendvi41.entities.Unit;
import com.gmail.sendvi41.services.UnitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

import org.apache.log4j.Logger;

@Service
public class UnitFormatter  implements Formatter<Unit>  {

    private final Logger logger = Logger.getLogger(UnitFormatter.class.getName());

    @Autowired
    @Qualifier("unitService")
    UnitServiceInterface unitServiceInterface;

    public  UnitFormatter() {
        super();
    }


    @Override
    public String print(Unit object, Locale locale) {
        logger.info("Successful function launch print");
        return (object != null ? object.getId().toString() : "");
    }

    @Override
    public Unit parse(String text, Locale locale) throws ParseException {
        logger.info("Successful function launch parse");

        Long id = Long.parseLong(text);
        logger.info("ID recognition successful" + id);
        return this.unitServiceInterface.getUnit(id);//return Type object form DB
    }



}
