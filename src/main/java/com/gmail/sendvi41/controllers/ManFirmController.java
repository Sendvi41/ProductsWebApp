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

@Controller
public class ManFirmController {

    @Autowired
    @Qualifier("manFirmService")
    ManFirmServiceInterface manFirmServiceInterface;


    @GetMapping("/listmanfirms")
    public String showListManFirmsPage(Model model) {
        model.addAttribute("manfirms", manFirmServiceInterface.getManFirms());
        return "manfirms/list-manfirms";
    }


    @GetMapping("/addmanfirm")
    public String showAddManFirmPage(Model model) {
        ManFirm manFirm = new ManFirm();
        model.addAttribute("manfirm", manFirm);

        return "manfirms/add-manfirm";
    }



    @PostMapping("/savemanfirm")
    public String saveManFirm(@ModelAttribute("manfirm") ManFirm manFirm, Model model) {

        if (manFirmServiceInterface.findByName(manFirm.getName())) {
            model.addAttribute(manFirm);
            return "manfirms/manfirmexsist";
        } else {
            manFirmServiceInterface.saveManFirm(manFirm);
        }


        return "redirect:/listmanfirms";

    }


    @GetMapping("/editmanfirm/{id}")
    public String showUpdateFormManFirm(@PathVariable("id") long id, Model model) {
        try {
            ManFirm manFirm = manFirmServiceInterface.getManFirm(id);

            model.addAttribute("manfirm", manFirm);

            return "manfirms/update-manfirm";
        } catch (Exception ex) {
            return "manfirms/manfirm-deleted";
        }
    }


    @PostMapping("/updatemanfirm/{id}")
    public String updateManFirm(@PathVariable("id") long id, @ModelAttribute("manfirm") ManFirm manFirm,
                                 Model model) {
        try {
            manFirmServiceInterface.getManFirm(id);
            manFirmServiceInterface.saveManFirm(manFirm);

            return "redirect:/listmanfirms";
        } catch (Exception ex) {
            return "manfirms/manfirm-deleted";
        }


    }

    @GetMapping("/deletemanfirm/{id}")
    public String deleteManFirm(@PathVariable("id") long id, Model model) {
        try {
            manFirmServiceInterface.deleteManFirm(id);
            return "redirect:/listmanfirms";
        } catch (Exception ex) {
            return "redirect:/listmanfirms";
        }

    }






}
