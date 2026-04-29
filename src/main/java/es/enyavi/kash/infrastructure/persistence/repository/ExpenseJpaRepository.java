package es.enyavi.kash.infrastructure.persistence.repository;

import es.enyavi.kash.infrastructure.persistence.entity.EnvelopeEntity;
import es.enyavi.kash.infrastructure.persistence.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseJpaRepository extends JpaRepository<ExpenseEntity, Long> {
    List<ExpenseEntity> findByEnvelope(EnvelopeEntity envelope);
    List<ExpenseEntity> findByDateBetween(LocalDate from, LocalDate to);
}