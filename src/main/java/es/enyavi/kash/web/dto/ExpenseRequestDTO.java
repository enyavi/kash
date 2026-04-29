package es.enyavi.kash.web.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseRequestDTO {
    private Long envelopeId;
    private Long categoryId;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
}