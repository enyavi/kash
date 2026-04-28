package es.enyavi.kash.infrastructure.persistence.adapter;

import es.enyavi.kash.domain.model.*;
import es.enyavi.kash.domain.port.out.MovementRepository;
import es.enyavi.kash.infrastructure.persistence.EnvelopeLoadJpaRepository;
import es.enyavi.kash.infrastructure.persistence.ExpenseJpaRepository;
import es.enyavi.kash.infrastructure.persistence.TransferJpaRepository;
import es.enyavi.kash.infrastructure.persistence.WithdrawalJpaRepository;
import es.enyavi.kash.infrastructure.persistence.mapper.EnvelopeMapper;
import es.enyavi.kash.infrastructure.persistence.mapper.MovementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovementRepositoryAdapter implements MovementRepository {

    private final ExpenseJpaRepository expenseJpaRepository;
    private final WithdrawalJpaRepository withdrawalJpaRepository;
    private final TransferJpaRepository transferJpaRepository;
    private final EnvelopeLoadJpaRepository envelopeLoadJpaRepository;
    private final MovementMapper movementMapper;
    private final EnvelopeMapper envelopeMapper;

    @Override
    public EnvelopeLoad save(EnvelopeLoad envelopeLoad) {
        return movementMapper.toDomain(
                envelopeLoadJpaRepository.save(movementMapper.toEntity(envelopeLoad)));
    }

    @Override
    public Withdrawal save(Withdrawal withdrawal) {
        return movementMapper.toDomain(
                withdrawalJpaRepository.save(movementMapper.toEntity(withdrawal)));
    }

    @Override
    public Expense save(Expense expense) {
        return movementMapper.toDomain(
                expenseJpaRepository.save(movementMapper.toEntity(expense)));
    }

    @Override
    public Transfer save(Transfer transfer) {
        return movementMapper.toDomain(
                transferJpaRepository.save(movementMapper.toEntity(transfer)));
    }

    @Override
    public Optional<Expense> findExpenseById(Long id) {
        return expenseJpaRepository.findById(id).map(movementMapper::toDomain);
    }

    @Override
    public Optional<Withdrawal> findWithdrawalById(Long id) {
        return withdrawalJpaRepository.findById(id).map(movementMapper::toDomain);
    }

    @Override
    public Optional<Transfer> findTransferById(Long id) {
        return transferJpaRepository.findById(id).map(movementMapper::toDomain);
    }

    @Override
    public Optional<EnvelopeLoad> findEnvelopeLoadById(Long id) {
        return envelopeLoadJpaRepository.findById(id).map(movementMapper::toDomain);
    }

    @Override
    public List<Expense> findExpensesByEnvelope(Envelope envelope) {
        return expenseJpaRepository.findByEnvelope(envelopeMapper.toEntity(envelope))
                .stream().map(movementMapper::toDomain).toList();
    }

    @Override
    public List<Withdrawal> findWithdrawalsByEnvelope(Envelope envelope) {
        return withdrawalJpaRepository.findByEnvelope(envelopeMapper.toEntity(envelope))
                .stream().map(movementMapper::toDomain).toList();
    }

    @Override
    public List<Transfer> findTransfersByEnvelope(Envelope envelope) {
        return transferJpaRepository.findByEnvelope(envelopeMapper.toEntity(envelope))
                .stream().map(movementMapper::toDomain).toList();
    }

    @Override
    public List<Expense> findExpensesByDateBetween(LocalDate from, LocalDate to) {
        return expenseJpaRepository.findByDateBetween(from, to)
                .stream().map(movementMapper::toDomain).toList();
    }
}