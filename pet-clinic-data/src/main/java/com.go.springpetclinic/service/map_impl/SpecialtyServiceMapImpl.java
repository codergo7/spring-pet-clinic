package com.go.springpetclinic.service.map_impl;

import com.go.springpetclinic.model.Specialty;
import com.go.springpetclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Profile({"default","map"})
public class SpecialtyServiceMapImpl extends AbstractMapService<Specialty,Long> implements SpecialtyService {
    @Override
    public Collection<Specialty> findAll() {
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
