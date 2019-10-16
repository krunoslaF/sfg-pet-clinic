package org.springframework.sftpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType("cat");
        petTypeService.save(cat);

        PetType dog = new PetType("dog");
        petTypeService.save(dog);

        Pet juliasCat = new Pet();
        juliasCat.setPetType(cat);
        juliasCat.setBirthDate(LocalDate.now().minusYears(2));
        juliasCat.setName("Mandu");

        Set<Pet> juliasPets = new HashSet<>();
        juliasPets.add(juliasCat);


        Owner owner3 = new Owner();
        owner3.setFirstName("Julia");
        owner3.setLastName("Roberts");
        owner3.setAddress("Ilica 33");
        owner3.setCity("Poganovci");
        owner3.setTelephone("1234");
        owner3.setPets(juliasPets);
        juliasCat.setOwner(owner3);
        ownerService.save(owner3);

        Pet mattsDog = new Pet();
        mattsDog.setPetType(dog);
        mattsDog.setBirthDate(LocalDate.now().minusYears(3));
        mattsDog.setName("Hulk");

        Set<Pet> mattsPets = new HashSet<>();
        mattsPets.add(mattsDog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Matt");
        owner1.setLastName("Le Tissier");
        owner1.setAddress("Majevička 42");
        owner1.setCity("New York");
        owner1.setTelephone("4321");
        owner1.setPets(mattsPets);
        mattsDog.setOwner(owner1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gail");
        owner2.setLastName("Deverse");
        owner2.setAddress("Franje Tuđmana 11");
        owner2.setCity("Pogana Vlaka");
        ownerService.save(owner2);


        log.info("Loaded " + ownerService.findAll().size() + " Owners....");
        log.info("Loaded " + petTypeService.findAll().size() + " PetTypes....");

        Set<Specialty> spec1 = new HashSet<>();
        spec1.add(new Specialty("birds"));


        Set<Specialty> spec2 = new HashSet<>();
        spec2.add(new Specialty("large dogs"));

        Set<Specialty> spec3 = new HashSet<>();
        spec3.add(new Specialty("poultry"));

        Set<Specialty> spec4 = new HashSet<>();
        spec4.add(new Specialty("cows"));


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.setSpecialties(spec1);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.setSpecialties(spec2);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("John");
        vet3.setLastName("Doe");
        vet3.setSpecialties(spec3);

        vetService.save(vet3);

        Vet vet4 = new Vet();
        vet4.setFirstName("Jimmy");
        vet4.setLastName("Carter");
        vet4.setSpecialties(spec4);

        vetService.save(vet4);

        log.info("Loaded list of " + vetService.findAll().size() + " Vets....");

        ownerService.findAll().stream().forEach(System.out::println);

    }
}
