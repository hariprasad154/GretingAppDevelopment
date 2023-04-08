package com.bridgelabs.greetingAppDevelopment.model;

import com.bridgelabs.greetingAppDevelopment.dto.MyDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Mymodel {
    public Mymodel(MyDTO mydto) {
        this.firstName = mydto.firstName;
        this.lastName = mydto.lastName;
        this.greeting = mydto.greeting;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Id
    @GeneratedValue
    private long Id;
    private String firstName;
    private String lastName;

    private String greeting;


}
