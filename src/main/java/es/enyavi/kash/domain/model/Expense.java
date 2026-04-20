package es.enyavi.kash.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Expense extends Movement {
    private Envelope envelope;
    private Category category;
    private Withdrawal withdrawal;  // nullable

    public Expense(Long id, LocalDate date, BigDecimal amount, String description,
                   Envelope envelope, Category category, Withdrawal withdrawal) {
        super(id, date, amount, description, MovementType.EXPENSE);
        this.envelope = envelope;
        this.category = category;
        this.withdrawal = withdrawal;
    }
}