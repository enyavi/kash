package es.enyavi.kash.infrastructure.persistence.entity;

import es.enyavi.kash.domain.model.BankAccount;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("TRANSFER")
public class TransferEntity extends MovementEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENVELOPE_ID", nullable = false)
    private EnvelopeEntity envelope;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BankAccount destination;
}