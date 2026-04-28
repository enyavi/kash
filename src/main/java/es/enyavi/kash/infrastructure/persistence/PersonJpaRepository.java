package es.enyavi.kash.infrastructure.persistence;

import es.enyavi.kash.infrastructure.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}