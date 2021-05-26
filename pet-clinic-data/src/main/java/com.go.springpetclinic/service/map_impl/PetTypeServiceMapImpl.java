package com.go.springpetclinic.service.map_impl;

import com.go.springpetclinic.model.PetType;
import com.go.springpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Profile("servicemap")
public class PetTypeServiceMapImpl extends AbstractMapService<PetType,Long> implements PetTypeService {
    @Override
    public Collection<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save( object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
