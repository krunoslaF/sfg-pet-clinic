package org.springframework.sftpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Matt");
        owner1.setLastName("Le Tissier");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gail");
        owner2.setLastName("Deverse");

        ownerService.save(owner2);


        System.out.println("Loaded " + ownerService.findAll().size() + " Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("John");
        vet3.setLastName("Doe");

        vetService.save(vet3);

        Vet vet4 = new Vet();
        vet4.setFirstName("Jimmy");
        vet4.setLastName("Carter");

        vetService.save(vet4);

        System.out.println("Loaded list of " + vetService.findAll().size() + " Vets....");

    }
}
