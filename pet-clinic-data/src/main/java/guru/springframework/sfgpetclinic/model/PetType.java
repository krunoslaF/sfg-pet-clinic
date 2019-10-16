package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

public class PetType extends BaseEntity implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "name='" + name + '\'' +
                super.toString() +
                '}';
    }
}
