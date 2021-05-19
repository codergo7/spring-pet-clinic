package com.go.springpetclinic.bootstrap;

import com.go.springpetclinic.model.Owner;
import com.go.springpetclinic.model.Pet;
import com.go.springpetclinic.model.PetType;
import com.go.springpetclinic.model.Vet;
import com.go.springpetclinic.service.OwnerService;
import com.go.springpetclinic.service.PetService;
import com.go.springpetclinic.service.PetTypeService;
import com.go.springpetclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 BlaBla");
        owner1.setCity("Brussels");
        owner1.setTelephone("555555555555");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona2");
        owner2.setLastName("Glenanne2");
        owner2.setAddress("895 BlaBla");
        owner2.setCity("Leuven");
        owner2.setTelephone("7777777777");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

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
