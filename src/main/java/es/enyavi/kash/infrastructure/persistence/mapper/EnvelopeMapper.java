package es.enyavi.kash.infrastructure.persistence.mapper;

import es.enyavi.kash.domain.model.Envelope;
import es.enyavi.kash.infrastructure.persistence.entity.EnvelopeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnvelopeMapper {
    Envelope toDomain(EnvelopeEntity entity);
    EnvelopeEntity toEntity(Envelope domain);
}