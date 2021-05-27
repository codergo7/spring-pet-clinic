package com.go.springpetclinic.service.sd_impl;

import com.go.springpetclinic.model.Visit;
import com.go.springpetclinic.repository.VisitRepository;
import com.go.springpetclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VisitSDServiceImpl implements VisitService {

    private final VisitRepository visitRepository;


    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
