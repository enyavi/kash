package es.enyavi.kash.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Movement {
    private Long id;
    private LocalDate date;
    private BigDecimal amount;
    private String description;
    private MovementType type;
}
