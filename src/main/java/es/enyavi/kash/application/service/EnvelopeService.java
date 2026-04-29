package es.enyavi.kash.application.service;

import es.enyavi.kash.domain.model.Envelope;
import es.enyavi.kash.domain.model.EnvelopeType;
import es.enyavi.kash.domain.port.out.EnvelopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnvelopeService {

    private final EnvelopeRepository envelopeRepository;

    public Envelope findById(Long id) {
        return envelopeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Envelope not found: " + id));
    }

    public Envelope findByType(EnvelopeType type) {
        return envelopeRepository.findByType(type)
                .orElseThrow(() -> new IllegalArgumentException("Envelope not found: " + type));
    }

    public List<Envelope> findAll() {
        return envelopeRepository.findAll();
    }

    public Envelope save(Envelope envelope) {
        return envelopeRepository.save(envelope);
    }
}