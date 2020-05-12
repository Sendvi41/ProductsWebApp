package com.gmail.sendvi41.entities;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "man_firms")
public class ManFirm {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ_MAN")
    private Long id;

    @Column(name = "name",  nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manFirm_id")
    private Set<Product> products;

    public ManFirm() {
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManFirm manFirm = (ManFirm) o;
        return Objects.equals(id, manFirm.id) &&
                Objects.equals(name, manFirm.name) &&
                Objects.equals(products, manFirm.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }
}
