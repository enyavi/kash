package es.enyavi.kash.domain.port.out;

import es.enyavi.kash.domain.model.Envelope;
import es.enyavi.kash.domain.model.EnvelopeType;

import java.util.List;
import java.util.Optional;

public interface EnvelopeRepository {
    Envelope save(Envelope envelope);
    Optional<Envelope> findById(Long id);
    Optional<Envelope> findByType(EnvelopeType type);
    List<Envelope> findAll();
}