package com.go.springpetclinic.service.map_impl;

import com.go.springpetclinic.model.Pet;
import com.go.springpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("servicemap")
public class PetServiceMapImpl extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save( object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
