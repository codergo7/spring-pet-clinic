package com.go.springpetclinic.service.map_impl;

import com.go.springpetclinic.model.Visit;
import com.go.springpetclinic.repository.VisitRepository;
import com.go.springpetclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Profile({"default","map"})
@RequiredArgsConstructor
public class VisitServiceMapImpl extends AbstractMapService<Visit,Long> implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public Collection<Visit> findAll() {
        return  super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
            throw  new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
