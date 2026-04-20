package es.enyavi.kash.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("EXPENSE")
public class ExpenseEntity extends MovementEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENVELOPE_ID", nullable = false)
    private EnvelopeEntity envelope;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WITHDRAWAL_ID")
    private WithdrawalEntity withdrawal;
}