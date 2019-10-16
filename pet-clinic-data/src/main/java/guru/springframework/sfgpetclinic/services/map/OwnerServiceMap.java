package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


    private final PetService petService;
    private final PetTypeService petTypeService;


    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {

            if ((object.getPets() != null) && (!object.getPets().isEmpty())) {
                object.getPets().stream()
                        .forEach(pet -> {
                            if (pet.getPetType() != null){
                                if (pet.getPetType().getId() == null) {
                                    pet.setPetType(petTypeService.save(pet.getPetType()));
                                }
                                if (pet.getId() == null) {
                                    pet.setId(petService.save(pet).getId());
                                }
                            } else throw new RuntimeException("PetType is mandatory");

                            });
            }

            return super.save(object);

        } else return null;

    }

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> ownerSet = super.findAll();
        Optional<Owner> ownerOptional = ownerSet.stream()
                .findFirst().filter(item -> item.getLastName().equalsIgnoreCase(lastName));
        return ownerOptional.orElse(new Owner());
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
