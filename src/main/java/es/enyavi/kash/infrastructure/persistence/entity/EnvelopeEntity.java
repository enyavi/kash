package es.enyavi.kash.infrastructure.persistence.entity;

import es.enyavi.kash.domain.model.EnvelopeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENVELOPE")
public class EnvelopeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private EnvelopeType type;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal balance;
}
