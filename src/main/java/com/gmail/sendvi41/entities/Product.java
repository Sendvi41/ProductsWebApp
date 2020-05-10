package com.gmail.sendvi41.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ_PROD")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "man_firm_id", nullable = false)
    private ManFirm manFirm_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit_id;

    @Column(name = "unit_price", nullable = false)
    private double unit_price;

    @Column(name = "amount", nullable = false)
    private int amount;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "date_of_last_delivery", nullable = false)
    private Date dateTime;


    public Product() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public ManFirm getManFirm_id() {
        return manFirm_id;
    }

    public void setManFirm_id(ManFirm manFirm_id) {
        this.manFirm_id = manFirm_id;
    }

    public Unit getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Unit unit_id) {
        this.unit_id = unit_id;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                ", manFirm_id=" + manFirm_id +
                ", unit_id=" + unit_id +
                ", unit_price=" + unit_price +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }

}
