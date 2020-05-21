package com.gmail.sendvi41.controllers;



import com.gmail.sendvi41.entities.Unit;
import com.gmail.sendvi41.services.UnitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UnitController {

    @Autowired
    @Qualifier("unitService")
    UnitServiceInterface unitServiceInterface;


    @GetMapping("/listunits")
    public String showListUnitsPage(Model model) {
        model.addAttribute("units", unitServiceInterface.getUnits());
        return "units/list-units";
    }


    @GetMapping("/addunit")
    public String showAddUnitPage(Model model) {
        Unit unit = new Unit();
        model.addAttribute("unit", unit);

        return "units/add-unit";
    }


    @PostMapping("/saveunit")
    public String saveUnit(@ModelAttribute("unit") Unit unit, Model model) {

        if (unitServiceInterface.findByName(unit.getName())) {
            model.addAttribute(unit);
            return "units/unitexsist";
        } else {
            unitServiceInterface.saveUnit(unit);
        }


        return "redirect:/listunits";

    }


    @GetMapping("/editunit/{id}")
    public String showUpdateFormUnit(@PathVariable("id") long id, Model model) {
        try {
            Unit unit = unitServiceInterface.getUnit(id);

            model.addAttribute("unit", unit);

            return "units/update-unit";
        } catch (Exception ex) {
            return "units/unit-deleted";
        }
    }


    @PostMapping("/updateunit/{id}")
    public String updateUnit(@PathVariable("id") long id, @ModelAttribute("unit") Unit unit,
                                 Model model) {
        try {
            unitServiceInterface.getUnit(id);
            unitServiceInterface.saveUnit(unit);

            return "redirect:/listunits";
        } catch (Exception ex) {
            return "units/unit-deleted";
        }


    }

    @GetMapping("/deleteunit/{id}")
    public String deleteUnit(@PathVariable("id") long id, Model model) {
        try {
            unitServiceInterface.deleteUnit(id);
            return "redirect:/listunits";
        } catch (Exception ex) {
            return "redirect:/listunits";
        }

    }




}
