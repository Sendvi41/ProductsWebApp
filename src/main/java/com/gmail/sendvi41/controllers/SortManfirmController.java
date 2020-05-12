package com.gmail.sendvi41.controllers;



import com.gmail.sendvi41.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class SortManfirmController {



    @Autowired
    @Qualifier("productService")
    ProductServiceInterface productServiceInterface;

    @GetMapping("/sortmanfirm")
    public String showAddProductPage(Model model) {
        model.addAttribute("manfirm", productServiceInterface.getJoinManFirmCategory());

        return "sortmanfirm/sort_manfirm";
    }
}
