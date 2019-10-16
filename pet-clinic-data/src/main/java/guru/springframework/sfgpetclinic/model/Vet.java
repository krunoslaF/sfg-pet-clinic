package guru.springframework.sfgpetclinic.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    @Override
    public String toString() {
        return "Vet{" +
                "specialties=" + specialties +
                super.toString() +
                '}';
    }
}
