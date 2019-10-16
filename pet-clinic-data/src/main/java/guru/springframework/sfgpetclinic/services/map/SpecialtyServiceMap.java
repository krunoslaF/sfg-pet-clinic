package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author kguldan
 */
@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) super.deleteById(id);
    }

    @Override
    public Specialty save(Specialty object) {

        return super.save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return id != null ? super.findById(id) : null;
    }
}
