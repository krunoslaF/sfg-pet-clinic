package guru.springframework.sfgpetclinic.services.map;


import guru.springframework.sfgpetclinic.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();


    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(Long id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null){
            Long id = getNextId();
            object.setId(id);
            map.put(id, object);
            return object;
        } else throw new RuntimeException("Object cannot be null");
    }

    void deleteById(Long id) {
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteAll(){
        map.clear();
    }

    private Long getNextId() {
        Long toReturn = null;
        try {
            toReturn = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            toReturn = 1L;
        }
        log.info("Dodajem objektu ID: " + toReturn);
        return toReturn;
    }
}
