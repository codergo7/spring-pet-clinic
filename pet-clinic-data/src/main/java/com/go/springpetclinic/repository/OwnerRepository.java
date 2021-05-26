package com.go.springpetclinic.repository;

import com.go.springpetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
