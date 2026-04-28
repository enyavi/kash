package es.enyavi.kash.infrastructure.persistence;

import es.enyavi.kash.domain.model.EnvelopeType;
import es.enyavi.kash.infrastructure.persistence.entity.EnvelopeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnvelopeJpaRepository extends JpaRepository<EnvelopeEntity, Long> {
    Optional<EnvelopeEntity> findByType(EnvelopeType type);
}