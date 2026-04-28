package es.enyavi.kash.infrastructure.persistence;

import es.enyavi.kash.infrastructure.persistence.entity.EnvelopeEntity;
import es.enyavi.kash.infrastructure.persistence.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferJpaRepository extends JpaRepository<TransferEntity, Long> {
    List<TransferEntity> findByEnvelope(EnvelopeEntity envelope);
}