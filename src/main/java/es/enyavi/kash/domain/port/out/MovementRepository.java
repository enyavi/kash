package es.enyavi.kash.domain.port.out;

import es.enyavi.kash.domain.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovementRepository {
    EnvelopeLoad save(EnvelopeLoad envelopeLoad);
    Withdrawal save(Withdrawal withdrawal);
    Expense save(Expense expense);
    Transfer save(Transfer transfer);

    Optional<Expense> findExpenseById(Long id);
    Optional<Withdrawal> findWithdrawalById(Long id);
    Optional<Transfer> findTransferById(Long id);
    Optional<EnvelopeLoad> findEnvelopeLoadById(Long id);

    List<Expense> findExpensesByEnvelope(Envelope envelope);
    List<Withdrawal> findWithdrawalsByEnvelope(Envelope envelope);
    List<Transfer> findTransfersByEnvelope(Envelope envelope);

    List<Expense> findExpensesByDateBetween(LocalDate from, LocalDate to);
}