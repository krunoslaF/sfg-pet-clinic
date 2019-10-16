package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.sftpetclinic.SfgPetClinicApplication;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SfgPetClinicApplication.class)
public class SfgPetClinicApplicationTests {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private VetService vetService;

    @Test
    public void contextLoads() {
    }

    @Test
    @DirtiesContext
    public void saveOwners() {

        ownerService.deleteAll();


        Owner owner2 = new Owner();
        owner2.setFirstName("Gail");
        owner2.setLastName("Deverse");

        ownerService.save(owner2);

        Owner owner1 = new Owner();
        owner1.setFirstName("Matt");
        owner1.setLastName("Le Tissier");

        ownerService.save(owner1);

        Set<Owner> ownerSet = ownerService.findAll();



        assertEquals(2, ownerSet.size());
    }


    @Test
    @After
    @DirtiesContext
    public void saveVets() {

        vetService.deleteAll();

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

        vetService.findAll().stream()
                .forEach(a -> System.out.println(a.toString()));

        Assert.assertEquals(4, vetService.findAll().size());
    }


}
