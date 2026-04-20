package es.enyavi.kash.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EnvelopeLoad extends Movement {
    private Envelope envelope;
    private Person person;

    public EnvelopeLoad(Long id, LocalDate date, BigDecimal amount, String description,
                        Envelope envelope, Person person) {
        super(id, date, amount, description, MovementType.ENVELOPE_LOAD);
        this.envelope = envelope;
        this.person = person;
    }
}