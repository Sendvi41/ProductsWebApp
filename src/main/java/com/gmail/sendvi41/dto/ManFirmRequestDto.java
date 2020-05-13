package com.gmail.sendvi41.dto;





public class ManFirmRequestDto {

    private String manFirm;
    private Long  sumamount;
    private String categories;
    private Long amountcategor;
    private Double percent;



    public ManFirmRequestDto(String manFirm, Long sumamount, String categories, Long amountcategor) {
        this.manFirm = manFirm;
        this.sumamount = sumamount;
        this.amountcategor=amountcategor;
        this.categories = categories;
        this.percent = (double)Math.round(((double)amountcategor/sumamount)*1000)/10;

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

    public Long getAmountcategor() {
        return amountcategor;
    }

    public void setAmountcategor(Long amountcategor) {
        this.amountcategor = amountcategor;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }


}