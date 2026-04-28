package es.enyavi.kash.infrastructure.persistence.adapter;

import es.enyavi.kash.domain.model.Envelope;
import es.enyavi.kash.domain.model.EnvelopeType;
import es.enyavi.kash.domain.port.out.EnvelopeRepository;
import es.enyavi.kash.infrastructure.persistence.EnvelopeJpaRepository;
import es.enyavi.kash.infrastructure.persistence.mapper.EnvelopeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EnvelopeRepositoryAdapter implements EnvelopeRepository {

    private final EnvelopeJpaRepository jpaRepository;
    private final EnvelopeMapper mapper;

    @Override
    public Envelope save(Envelope envelope) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(envelope)));
    }

    @Override
    public Optional<Envelope> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Envelope> findByType(EnvelopeType type) {
        return jpaRepository.findByType(type).map(mapper::toDomain);
    }

    @Override
    public List<Envelope> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }
}