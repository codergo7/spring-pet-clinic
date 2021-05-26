package com.go.springpetclinic.service.sd_impl;

import com.go.springpetclinic.model.Specialty;
import com.go.springpetclinic.repository.SpecialtyRepository;
import com.go.springpetclinic.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class SpecialtySDServiceImpl implements SpecialtyService{

    private final SpecialtyRepository Specialty;

    @Override
    public List<Specialty> findAll() {
        return Specialty.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return Specialty.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Specialty save(Specialty object) {
        return Specialty.save(object);
    }

    @Override
    public void delete(Specialty object) {
        Specialty.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        Specialty.deleteById(id);
    }
}
