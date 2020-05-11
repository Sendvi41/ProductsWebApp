package com.gmail.sendvi41.conversion;



import com.gmail.sendvi41.entities.ManFirm;
import com.gmail.sendvi41.services.ManFirmServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class ManFirmFormatter implements Formatter<ManFirm> {

    @Autowired
    @Qualifier("manFirmService")
    ManFirmServiceInterface manFirmServiceInterface;

    public  ManFirmFormatter() {
        super();
    }


    @Override
    public String print(ManFirm object, Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }

    @Override
    public ManFirm parse(String text, Locale locale) throws ParseException {
        Long id = Long.parseLong(text);
        return this.manFirmServiceInterface.getManFirm(id);//return Type object form DB
    }
}

