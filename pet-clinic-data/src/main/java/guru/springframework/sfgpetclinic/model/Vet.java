package guru.springframework.sfgpetclinic.model;

import lombok.Data;

import java.util.Set;

@Data
public class Vet extends Person {

    private Set<Specialty> specialties;

    @Override
    public String toString() {
        return "Vet{" +
                "specialties=" + specialties +
                super.toString() +
                '}';
    }
}
