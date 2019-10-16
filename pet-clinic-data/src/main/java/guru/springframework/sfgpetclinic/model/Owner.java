package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets;

}
