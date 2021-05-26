package com.go.springpetclinic.service.sd_impl;

import com.go.springpetclinic.model.Owner;
import com.go.springpetclinic.repository.OwnerRepository;
import com.go.springpetclinic.repository.PetRepository;
import com.go.springpetclinic.repository.PetTypeRepository;
import com.go.springpetclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class OwnerSDServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;


    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {

        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
