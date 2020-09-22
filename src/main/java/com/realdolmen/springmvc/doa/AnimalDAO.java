package com.realdolmen.springmvc.doa;

import com.realdolmen.springmvc.models.Animal;

import java.util.List;

public interface AnimalDAO {
    public List<Animal> getAllAnimals();
}