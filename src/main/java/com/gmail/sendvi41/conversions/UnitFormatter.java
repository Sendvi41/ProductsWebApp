package com.gmail.sendvi41.conversions;



import com.gmail.sendvi41.entities.Unit;
import com.gmail.sendvi41.services.UnitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;


@Service
public class UnitFormatter  implements Formatter<Unit>  {

    @Autowired
    @Qualifier("unitService")
    UnitServiceInterface unitServiceInterface;

    public  UnitFormatter() {
        super();
    }


    @Override
    public String print(Unit object, Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }

    @Override
    public Unit parse(String text, Locale locale) throws ParseException {
        Long id = Long.parseLong(text);
        return this.unitServiceInterface.getUnit(id);//return Type object form DB
    }



}
