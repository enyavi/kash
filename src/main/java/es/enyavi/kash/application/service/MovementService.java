package es.enyavi.kash.application.service;

import es.enyavi.kash.domain.model.*;
import es.enyavi.kash.domain.port.out.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository movementRepository;
    private final EnvelopeService envelopeService;

    @Transactional
    public EnvelopeLoad registerEnvelopeLoad(EnvelopeLoad envelopeLoad) {
        Envelope envelope = envelopeLoad.getEnvelope();
        envelope.setBalance(envelope.getBalance().add(envelopeLoad.getAmount()));
        envelopeService.save(envelope);
        return movementRepository.save(envelopeLoad);
    }

    @Transactional
    public Withdrawal registerWithdrawal(Withdrawal withdrawal) {
        Envelope envelope = withdrawal.getEnvelope();
        envelope.setBalance(envelope.getBalance().subtract(withdrawal.getAmount()));
        envelopeService.save(envelope);
        return movementRepository.save(withdrawal);
    }

    @Transactional
    public Expense registerExpense(Expense expense) {
        return movementRepository.save(expense);
    }

    @Transactional
    public Transfer registerTransfer(Transfer transfer) {
        Envelope origin = transfer.getEnvelope();
        origin.setBalance(origin.getBalance().subtract(transfer.getAmount()));
        envelopeService.save(origin);

        if (transfer.getDestinationEnvelope() != null) {
            Envelope destination = transfer.getDestinationEnvelope();
            destination.setBalance(destination.getBalance().add(transfer.getAmount()));
            envelopeService.save(destination);
        }

        return movementRepository.save(transfer);
    }

    public List<Expense> findExpensesByEnvelope(Envelope envelope) {
        return movementRepository.findExpensesByEnvelope(envelope);
    }

    public List<Expense> findExpensesByDateBetween(LocalDate from, LocalDate to) {
        return movementRepository.findExpensesByDateBetween(from, to);
    }
}