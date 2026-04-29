package es.enyavi.kash.infrastructure.persistence.adapter;

import es.enyavi.kash.domain.model.Person;
import es.enyavi.kash.domain.port.out.PersonRepository;
import es.enyavi.kash.infrastructure.persistence.repository.PersonJpaRepository;
import es.enyavi.kash.infrastructure.persistence.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonRepositoryAdapter implements PersonRepository {

    private final PersonJpaRepository jpaRepository;
    private final PersonMapper mapper;

    @Override
    public Person save(Person person) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(person)));
    }

    @Override
    public Optional<Person> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Person> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }
}