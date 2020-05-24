package com.gmail.sendvi41.controllers;



import com.gmail.sendvi41.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.log4j.Logger;




@Controller
public class SortManfirmController {

    private final Logger logger = Logger.getLogger(SortManfirmController.class.getName());

    @Autowired
    @Qualifier("productService")
    ProductServiceInterface productServiceInterface;

    @GetMapping("/sortmanfirm")
    public String showSortManfirmPage(Model model) {
        logger.info("Successful function launch showSortManfirmPage");

        model.addAttribute("manfirm", productServiceInterface.getJoinManFirmCategory());
        logger.info("Getting all objects of type ManFirmRequestDto and transferring objects to view");

        return "sortmanfirm/sort_manfirm";
    }
}
