package com.go.springpetclinic.service;

import com.go.springpetclinic.model.Owner;
import com.go.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
