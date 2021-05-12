package com.go.springpetclinic.bootstrap;

import com.go.springpetclinic.model.Owner;
import com.go.springpetclinic.model.Vet;
import com.go.springpetclinic.service.OwnerService;
import com.go.springpetclinic.service.PetService;
import com.go.springpetclinic.service.VetService;
import com.go.springpetclinic.service.map.OwnerServiceMap;
import com.go.springpetclinic.service.map.PetServiceMap;
import com.go.springpetclinic.service.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;


    public DataLoader(@Qualifier("ownerServiceMap") OwnerService ownerService, @Qualifier("vetServiceMap") VetService vetService, @Qualifier("petServiceMap")PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Fiona1");
        owner1.setLastName("Glenanne1");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona2");
        owner2.setLastName("Glenanne2");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam1");
        vet1.setLastName("Axe1");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Sam2");
        vet2.setLastName("Axe2");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
