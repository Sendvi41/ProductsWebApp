package com.gmail.sendvi41.dto;





public class CategoryRequestDto {
    String category;
    Long numberNames;
    Long   sumproduct;
    Double avgprice;
    Double   minprice;
    Double  maxprice;

    public CategoryRequestDto(String category, Long numberNames, Long sumproduct, Double avgprice, Double minprice, Double maxprice) {
        this.category = category;
        this.numberNames = numberNames;
        this.sumproduct = sumproduct;
        this.avgprice = avgprice;
        this.minprice = minprice;
        this.maxprice = maxprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getNumberNames() {
        return numberNames;
    }

    public void setNumberNames(Long numberNames) {
        this.numberNames = numberNames;
    }

    public Long getSumproduct() {
        return sumproduct;
    }

    public void setSumproduct(Long sumproduct) {
        this.sumproduct = sumproduct;
    }

    public Double getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(Double avgprice) {
        this.avgprice = avgprice;
    }

    public Double getMinprice() {
        return minprice;
    }

    public void setMinprice(Double minprice) {
        this.minprice = minprice;
    }

    public Double getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Double maxprice) {
        this.maxprice = maxprice;
    }
}
