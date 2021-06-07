package com.go.springpetclinic.service.map_impl;

import com.go.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapImplTest {

    OwnerServiceMapImpl ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Ozturk";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMapImpl(new PetServiceMapImpl(), new PetTypeServiceMapImpl());

        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = (Set<Owner>) ownerServiceMap.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {

        Owner owner2 = Owner.builder().id(2L).build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(2L, savedOwner.getId());

    }

    @Test
    void saveNoId() {

        Owner owner2 = Owner.builder().build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner2 = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner2);

        assertEquals(ownerId,owner2.getId());

    }

    @Test
    void findByLastNameNotFound() {
        Owner owner2 = ownerServiceMap.findByLastName("Foo");

        assertNull(owner2);
    }
}