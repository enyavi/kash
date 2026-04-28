package es.enyavi.kash.domain.port.out;

import es.enyavi.kash.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(Long id);
    List<Person> findAll();
}