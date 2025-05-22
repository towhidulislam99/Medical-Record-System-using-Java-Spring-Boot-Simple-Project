package com.mrs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Patience")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name")
    private String name;

    @Column(name = "Age")
    private String age;

    @Column(name = "Blood_Group")
    private String blood;

    @Column(name = "Prescriptions")
    private String prescription;

    @Column(name = "Dose")
    private String dose;

    @Column(name = "Fees")
    private String fees;

    @Column(name = "Urgency")
    private String urgency;


    public Patient(String name, String age, String blood, String prescription, String dose, String fees, String urgency) {
        this.name = name;
        this.age = age;
        this.blood = blood;
        this.prescription = prescription;
        this.dose = dose;
        this.fees = fees;
        this.urgency = urgency;
    }

    public Patient(){
        super();
        //TODO
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }


}






