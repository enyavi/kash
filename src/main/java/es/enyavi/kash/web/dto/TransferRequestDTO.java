package es.enyavi.kash.web.dto;

import es.enyavi.kash.domain.model.BankAccount;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransferRequestDTO {
    private Long envelopeId;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
    private BankAccount destinationBank;
    private Long destinationEnvelopeId;
}