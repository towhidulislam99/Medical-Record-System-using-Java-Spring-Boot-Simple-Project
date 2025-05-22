package com.mrs.docloginentity;


import jakarta.persistence.*;
import org.hibernate.annotations.JoinColumnOrFormula;

@Entity
@Table(name="Medicine")

public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "DrugName")
    private String drugName;

    @Column(name = "Stock")
    private String stock;


    public Medicine(long id, String drugName, String stock) {
        Id = id;
        this.drugName = drugName;
        this.stock = stock;
    }

    public Medicine(){
        super();
        //TODO
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
