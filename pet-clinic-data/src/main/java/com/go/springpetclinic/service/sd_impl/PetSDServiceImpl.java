package com.go.springpetclinic.service.sd_impl;

import com.go.springpetclinic.model.Pet;
import com.go.springpetclinic.repository.PetRepository;
import com.go.springpetclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetSDServiceImpl implements PetService{

    private final PetRepository petRepository;

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
