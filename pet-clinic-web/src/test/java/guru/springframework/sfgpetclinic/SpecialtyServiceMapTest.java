package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.sftpetclinic.SfgPetClinicApplication;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author kguldan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SfgPetClinicApplication.class)
public class SpecialtyServiceMapTest {

    @Autowired
    private SpecialtyService specialtyService;

    @Before
    public void setup(){

        specialtyService.deleteAll();

        assertTrue(specialtyService.findAll().size() == 0);

        Specialty spec1 = new Specialty();
        spec1.setDescription("farm animals");

        Specialty savedSpec1 = specialtyService.save(spec1);
        assertTrue(savedSpec1.equals(spec1));

        Specialty spec2 = new Specialty();
        spec2.setDescription("poultry");

        Specialty savedSpec2 = specialtyService.save(spec2);
        assertTrue(savedSpec2.equals(spec2));

        assertTrue(specialtyService.findAll().size() == 2);

    }


    @Test
    public void findAll() {
        assertEquals(2, specialtyService.findAll().size());
    }

    @Test
    public void save() {
        Specialty spec3 = new Specialty();
        spec3.setDescription("moskitos");

        Specialty savedSpec3= specialtyService.save(spec3);
        assertTrue(savedSpec3.equals(spec3));

        assertEquals(3, specialtyService.findAll().size());
    }

    @Test
    public void deleteAll() {
        specialtyService.deleteAll();
        assertTrue(specialtyService.findAll().size() == 0);
    }

    @Test
    public void deleteById() {
        Specialty spec3 = new Specialty();
        spec3.setDescription("Hippos");
        spec3.setId(specialtyService.save(spec3).getId());

        assertTrue(specialtyService.findAll().size() == 3);
        specialtyService.deleteById(spec3.getId());
        assertTrue(specialtyService.findAll().size() == 2);

        Specialty specObtained = specialtyService.findById(spec3.getId());
        assertTrue(specObtained == null);

    }

    @Test
    public void findById() {

        Specialty spec3 = new Specialty();
        spec3.setDescription("Rotweilers");
        spec3.setId(specialtyService.save(spec3).getId());

        Specialty specObtained = specialtyService.findById(spec3.getId());
        assertTrue(specObtained.equals(spec3));
    }




}