package com.gmail.sendvi41.controllers;



import com.gmail.sendvi41.entities.Unit;
import com.gmail.sendvi41.services.UnitServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.log4j.Logger;

@Controller
public class UnitController {

    private final Logger logger = Logger.getLogger(UnitController.class.getName());

    @Autowired
    @Qualifier("unitService")
    UnitServiceInterface unitServiceInterface;


    @GetMapping("/listunits")
    public String showListUnitsPage(Model model) {
        logger.info("Successful function launch showListUnitsPage");

        model.addAttribute("units", unitServiceInterface.getUnits());
        logger.info("Getting all objects of type unit and transferring objects to view");

        return "units/list-units";
    }


    @GetMapping("/addunit")
    public String showAddUnitPage(Model model) {
        logger.info("Successful function launch showAddUnitPage");

        Unit unit = new Unit();
        logger.info("Unit type object created");

        model.addAttribute("unit", unit);
        logger.info("Transferring object of type unit to view");

        return "units/add-unit";
    }


    @PostMapping("/saveunit")
    public String saveUnit(@ModelAttribute("unit") Unit unit, Model model) {
        logger.info("Successful function launch saveUnit");

        if (unitServiceInterface.findByName(unit.getName())) {
            logger.info("An object with the type unit already exists, name " + unit.getName());

            model.addAttribute(unit);
            logger.info("Transferring object of type unit to view");

            return "units/unitexsist";
        } else {
            unitServiceInterface.saveUnit(unit);
            logger.info("Successfully save a unit type object");
        }


        return "redirect:/listunits";

    }


    @GetMapping("/editunit/{id}")
    public String showUpdateFormUnit(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch showUpdateFormUnit");

        try {
            Unit unit = unitServiceInterface.getUnit(id);
            logger.info("Unit type object found successfully by id" + id);

            model.addAttribute("unit", unit);
            logger.info("Transferring object of type unit to view");

            return "units/update-unit";
        } catch (Exception ex) {
            logger.warn("Object unit by identifier" + id + "not found" + ex);
            return "units/unit-deleted";
        }
    }


    @PostMapping("/updateunit/{id}")
    public String updateUnit(@PathVariable("id") long id, @ModelAttribute("unit") Unit unit,
                                 Model model) {
        logger.info("Successful function launch updateunit");
        try {
            unitServiceInterface.getUnit(id);
            logger.info("Unit type object found successfully by" + id);

            unitServiceInterface.saveUnit(unit);
            logger.info("Successfully save a unit type object");

            return "redirect:/listunits";
        } catch (Exception ex) {
            logger.warn("Object unit by identifier" +id + "not found" +ex);
            return "units/unit-deleted";
        }


    }

    @GetMapping("/deleteunit/{id}")
    public String deleteUnit(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch deleteUnit");

        try {
            unitServiceInterface.deleteUnit(id);
            logger.info("Successfully delete a unit type object " + id);

            return "redirect:/listunits";
        } catch (Exception ex) {
            logger.warn("This unit type object was not found " + id + " "+ ex );
            return "redirect:/listunits";
        }

    }




}
