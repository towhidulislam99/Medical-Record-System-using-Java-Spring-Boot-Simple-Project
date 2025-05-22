package com.mrs.docloginentity;


import jakarta.persistence.*;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private String age;

    @Column(name= "Symptoms")
    private String symptoms;

    @Column(name= "Number")
    private String number;


    public Appointment(long id, String name, String age, String symptoms, String number) {
        Id = id;
        this.name = name;
        this.age = age;
        this.symptoms = symptoms;
        this.number = number;
    }

    public Appointment(){
        super();
        //TODO
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}


