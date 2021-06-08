package com.go.springpetclinic.service.sd_impl;

import com.go.springpetclinic.model.Owner;
import com.go.springpetclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDServiceImplTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDServiceImpl ownerSDService;

    public static final String LAST_NAME = "Smith";

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();

    }

    @Test
    void findAll() {
        List<Owner> owners = new ArrayList<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        List<Owner> ownersFindAll = ownerSDService.findAll();
        assertNotNull(ownersFindAll);
        assertEquals(2,ownersFindAll.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner ownerById = ownerSDService.findById(1L);
        assertNotNull(ownerById);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner ownerById = ownerSDService.findById(1L);
        assertNull(ownerById);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(ownerToSave)).thenReturn(owner);

        Owner savedOwner = ownerSDService.save(ownerToSave);

        assertNotNull(savedOwner);

        //default is 1 times
        verify(ownerRepository).save(any());
        //verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        ownerSDService.delete(owner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDService.deleteById(owner.getId());

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner ownerReturn = ownerSDService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, ownerReturn.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}