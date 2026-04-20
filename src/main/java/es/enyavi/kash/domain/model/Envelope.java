package es.enyavi.kash.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envelope {
    private Long id;
    private EnvelopeType type;
    private BigDecimal balance;
}
