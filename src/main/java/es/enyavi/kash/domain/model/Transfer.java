package es.enyavi.kash.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Transfer extends Movement {
    private Envelope envelope;
    private BankAccount destination;

    public Transfer(Long id, LocalDate date, BigDecimal amount, String description,
                    Envelope envelope, BankAccount destination) {
        super(id, date, amount, description, MovementType.TRANSFER);
        this.envelope = envelope;
        this.destination = destination;
    }
}