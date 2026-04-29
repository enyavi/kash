package es.enyavi.kash.web.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WithdrawalRequestDTO {
    private Long envelopeId;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
    private boolean directExpense;
}