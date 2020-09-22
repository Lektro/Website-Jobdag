package com.realdolmen.springmvc.models;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;

    //Setters and Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Employee [id =" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }
}
