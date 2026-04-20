package es.enyavi.kash.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Withdrawal extends Movement {
    private Envelope envelope;
    private boolean directExpense;
    private Category category;  // nullable si directExpense = false

    public Withdrawal(Long id, LocalDate date, BigDecimal amount, String description,
                      Envelope envelope, boolean directExpense, Category category) {
        super(id, date, amount, description, MovementType.WITHDRAWAL);
        this.envelope = envelope;
        this.directExpense = directExpense;
        this.category = category;
    }
}