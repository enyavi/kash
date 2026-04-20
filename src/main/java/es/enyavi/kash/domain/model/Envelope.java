package es.enyavi.kash.domain.model;

import java.math.BigDecimal;

public class Envelope {
    private Long id;
    private EnvelopeType type;
    private BigDecimal balance;

    public Envelope() {}

    public Envelope(EnvelopeType type, BigDecimal balance) {
        this.type = type;
        this.balance = balance;
    }

    public Long getId() { return id; }
    public EnvelopeType getType() { return type; }
    public BigDecimal getBalance() { return balance; }
    public void setId(Long id) { this.id = id; }
    public void setType(EnvelopeType type) { this.type = type; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
