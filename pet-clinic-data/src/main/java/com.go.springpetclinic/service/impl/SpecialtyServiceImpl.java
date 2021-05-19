package com.go.springpetclinic.service.impl;

import com.go.springpetclinic.model.Specialty;
import com.go.springpetclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyServiceImpl extends AbstractMapService<Specialty,Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save( object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
