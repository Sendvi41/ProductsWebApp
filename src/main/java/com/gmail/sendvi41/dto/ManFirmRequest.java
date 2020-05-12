package com.gmail.sendvi41.dto;


import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.entities.ManFirm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManFirmRequest {

    private ManFirm manFirm;
    private Integer sum;
    private List<Category> categories;
    private Double percent;

    public ManFirmRequest() {
    }

    public ManFirmRequest(ManFirm manFirm, Integer sum, List<Category> categories, Double percent) {
        this.manFirm = manFirm;
        this.sum = sum;
        this.categories = categories;
        this.percent = percent;
    }



    public ManFirm getManFirm() {
        return manFirm;
    }

    public void setManFirm(ManFirm manFirm) {
        this.manFirm = manFirm;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "ManFirmRequest{" +
                "manFirm=" + manFirm +
                ", sum=" + sum +
                ", categories=" + categories +
                ", percent=" + percent +
                '}';
    }
}
