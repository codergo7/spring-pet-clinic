package com.go.springpetclinic.service.sd_impl;

import com.go.springpetclinic.model.Vet;
import com.go.springpetclinic.repository.VetRepository;
import com.go.springpetclinic.service.SpecialtyService;
import com.go.springpetclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VetSDServiceImpl implements VetService {

    private final VetRepository vetRepository;


    @Override
    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
