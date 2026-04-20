package es.enyavi.kash.infrastructure.persistence.mapper;

import es.enyavi.kash.domain.model.*;
import es.enyavi.kash.infrastructure.persistence.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        EnvelopeMapper.class,
        CategoryMapper.class,
        PersonMapper.class
})
public interface MovementMapper {

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.date", target = "date")
    @Mapping(source = "entity.amount", target = "amount")
    @Mapping(source = "entity.description", target = "description")
    @Mapping(target = "type", ignore = true)
    EnvelopeLoad toDomain(EnvelopeLoadEntity entity);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.date", target = "date")
    @Mapping(source = "entity.amount", target = "amount")
    @Mapping(source = "entity.description", target = "description")
    @Mapping(target = "type", ignore = true)
    Withdrawal toDomain(WithdrawalEntity entity);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.date", target = "date")
    @Mapping(source = "entity.amount", target = "amount")
    @Mapping(source = "entity.description", target = "description")
    @Mapping(target = "type", ignore = true)
    Expense toDomain(ExpenseEntity entity);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.date", target = "date")
    @Mapping(source = "entity.amount", target = "amount")
    @Mapping(source = "entity.description", target = "description")
    @Mapping(target = "type", ignore = true)
    Transfer toDomain(TransferEntity entity);

    EnvelopeLoadEntity toEntity(EnvelopeLoad domain);
    WithdrawalEntity toEntity(Withdrawal domain);
    ExpenseEntity toEntity(Expense domain);
    TransferEntity toEntity(Transfer domain);
}