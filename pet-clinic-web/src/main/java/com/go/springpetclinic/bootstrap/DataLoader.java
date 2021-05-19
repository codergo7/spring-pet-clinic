package com.go.springpetclinic.bootstrap;

import com.go.springpetclinic.model.Owner;
import com.go.springpetclinic.model.PetType;
import com.go.springpetclinic.model.Vet;
import com.go.springpetclinic.service.OwnerService;
import com.go.springpetclinic.service.PetService;
import com.go.springpetclinic.service.PetTypeService;
import com.go.springpetclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona1");
        owner1.setLastName("Glenanne1");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona2");
        owner2.setLastName("Glenanne2");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam1");
        vet1.setLastName("Axe1");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam2");
        vet2.setLastName("Axe2");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
