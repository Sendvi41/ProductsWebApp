package com.gmail.sendvi41.controllers;


import com.gmail.sendvi41.entities.ManFirm;
import com.gmail.sendvi41.services.ManFirmServiceInterface;
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
public class ManFirmController {

    private final Logger logger = Logger.getLogger(ManFirmController.class.getName());

    @Autowired
    @Qualifier("manFirmService")
    ManFirmServiceInterface manFirmServiceInterface;


    @GetMapping("/listmanfirms")
    public String showListManFirmsPage(Model model) {
        logger.info("Successful function launch showListManFirmsPage");

        model.addAttribute("manfirms", manFirmServiceInterface.getManFirms());
        logger.info("Getting all objects of type manfirm and transferring objects to view");

        return "manfirms/list-manfirms";
    }


    @GetMapping("/addmanfirm")
    public String showAddManFirmPage(Model model) {
        logger.info("Successful function launch showAddManFirmPage");

        ManFirm manFirm = new ManFirm();
        logger.info("Manfirm type object created");

        model.addAttribute("manfirm", manFirm);
        logger.info("Transferring object of type manfirm to view");

        return "manfirms/add-manfirm";
    }



    @PostMapping("/savemanfirm")
    public String saveManFirm(@ModelAttribute("manfirm") ManFirm manFirm, Model model) {
        logger.info("Successful function launch saveManFirm");

        if (manFirmServiceInterface.findByName(manFirm.getName())) {
            logger.info("An object with the type manFirm already exists, name " + manFirm.getName());

            model.addAttribute(manFirm);
            logger.info("Transferring object of type manFirm to view");

            return "manfirms/manfirmexsist";
        } else {
            manFirmServiceInterface.saveManFirm(manFirm);
            logger.info("Successfully save a manFirm type object");
        }

        return "redirect:/listmanfirms";
    }


    @GetMapping("/editmanfirm/{id}")
    public String showUpdateFormManFirm(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch showUpdateFormManFirm");

        try {
            ManFirm manFirm = manFirmServiceInterface.getManFirm(id);
            logger.info("manFirm type object found successfully by id" + id);

            model.addAttribute("manfirm", manFirm);
            logger.info("Transferring object of type manFirm to view");

            return "manfirms/update-manfirm";
        } catch (Exception ex) {
            logger.warn("Object manfirm by identifier" + id + "not found" + ex);
            return "manfirms/manfirm-deleted";
        }
    }


    @PostMapping("/updatemanfirm/{id}")
    public String updateManFirm(@PathVariable("id") long id, @ModelAttribute("manfirm") ManFirm manFirm,
                                 Model model) {
        logger.info("Successful function launch updateManFirm");
        try {
            manFirmServiceInterface.getManFirm(id);
            logger.info("ManFirm type object found successfully by" + id);

            manFirmServiceInterface.saveManFirm(manFirm);
            logger.info("Successfully save a manfirm type object");

            return "redirect:/listmanfirms";
        } catch (Exception ex) {
            logger.warn("Object manfirm by identifier" +id + "not found" +ex);

            return "manfirms/manfirm-deleted";
        }


    }

    @GetMapping("/deletemanfirm/{id}")
    public String deleteManFirm(@PathVariable("id") long id, Model model) {
        logger.info("Successful function launch deleteManFirm");
        try {
            manFirmServiceInterface.deleteManFirm(id);
            logger.info("Successfully delete a manfirm type object " + id);

            return "redirect:/listmanfirms";
        } catch (Exception ex) {
            logger.warn("This manfirm type object was not found " + id + " "+ ex );
            return "redirect:/listmanfirms";
        }

    }






}
