package com.go.springpetclinic.service.map_impl;

import com.go.springpetclinic.model.Visit;
import com.go.springpetclinic.repository.VisitRepository;
import com.go.springpetclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Profile("servicemap")
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
    public Visit save(Visit object) {
        return super.save(object);
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
