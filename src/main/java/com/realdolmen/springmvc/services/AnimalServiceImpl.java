package com.realdolmen.springmvc.services;

import com.realdolmen.springmvc.doa.AnimalDAO;
import com.realdolmen.springmvc.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    AnimalDAO animalDAO;
    public List<Animal> getAllAnimals()
    {
        return animalDAO.getAllAnimals();
    }
}
