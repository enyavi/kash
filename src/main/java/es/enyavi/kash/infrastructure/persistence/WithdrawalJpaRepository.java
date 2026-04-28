package es.enyavi.kash.infrastructure.persistence;

import es.enyavi.kash.infrastructure.persistence.entity.EnvelopeEntity;
import es.enyavi.kash.infrastructure.persistence.entity.WithdrawalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalJpaRepository extends JpaRepository<WithdrawalEntity, Long> {
    List<WithdrawalEntity> findByEnvelope(EnvelopeEntity envelope);
}