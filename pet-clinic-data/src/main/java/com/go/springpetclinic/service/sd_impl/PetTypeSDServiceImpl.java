package com.go.springpetclinic.service.sd_impl;

import com.go.springpetclinic.model.PetType;
import com.go.springpetclinic.repository.PetTypeRepository;
import com.go.springpetclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetTypeSDServiceImpl implements PetTypeService{

    private final PetTypeRepository petTypeRepository;

    @Override
    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
