package com.go.springpetclinic.service.impl;

import com.go.springpetclinic.model.Specialty;
import com.go.springpetclinic.model.Vet;
import com.go.springpetclinic.service.SpecialtyService;
import com.go.springpetclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class VetServiceImpl extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
