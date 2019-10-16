package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author kguldan
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Specialty extends BaseEntity {

    private String description;

    public Specialty(String description) {
        this.description = description;
    }
}
