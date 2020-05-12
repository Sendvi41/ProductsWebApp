package com.gmail.sendvi41.dto;


import com.gmail.sendvi41.entities.Category;
import com.gmail.sendvi41.entities.ManFirm;

import org.springframework.stereotype.Component;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Objects;



public class ManFirmRequestDto {

    private String manFirm;
    private Long  sumamount;
    private String categories;
    private Long percent;



    public ManFirmRequestDto(String manFirm, Long sumamount, String categories, Long amountcategor) {
        this.manFirm = manFirm;
        this.sumamount = sumamount;
        this.categories = categories;
        this.percent = amountcategor/sumamount;
    }


    public String getManFirm() {
        return manFirm;
    }

    public void setManFirm(String manFirm) {
        this.manFirm = manFirm;
    }

    public Long getSumamount() {
        return sumamount;
    }

    public void setSumamount(Long sumamount) {
        this.sumamount = sumamount;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManFirmRequestDto that = (ManFirmRequestDto) o;
        return Objects.equals(manFirm, that.manFirm) &&
                Objects.equals(sumamount, that.sumamount) &&
                Objects.equals(categories, that.categories) &&
                Objects.equals(percent, that.percent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manFirm, sumamount, categories, percent);
    }
}