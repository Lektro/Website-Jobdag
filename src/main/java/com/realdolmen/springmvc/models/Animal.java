package com.realdolmen.springmvc.models;

public class Animal {
    private Integer id;
    private String animalName;
    private String species;
    private String foodType;

    //Setters and Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + animalName + '\'' +
                ", species='" + species + '\'' +
                ", foodType='" + foodType + '\'' +
                '}';
    }
}