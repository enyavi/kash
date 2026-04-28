package es.enyavi.kash.infrastructure.persistence;

import es.enyavi.kash.infrastructure.persistence.entity.EnvelopeEntity;
import es.enyavi.kash.infrastructure.persistence.entity.EnvelopeLoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnvelopeLoadJpaRepository extends JpaRepository<EnvelopeLoadEntity, Long> {
    List<EnvelopeLoadEntity> findByEnvelope(EnvelopeEntity envelope);
}