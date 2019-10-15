package guru.springframework.sfgpetclinic.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author kguldan
 */
@Data
public class Visit {

    private LocalDate date;
    private String description;
    private Pet pet;
}
