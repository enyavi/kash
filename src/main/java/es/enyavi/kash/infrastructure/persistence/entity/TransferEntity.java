package es.enyavi.kash.infrastructure.persistence.entity;

import es.enyavi.kash.domain.model.BankAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSFER")
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENVELOPE_ID", nullable = false)
    private EnvelopeEntity envelope;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BankAccount destination;
}