package es.enyavi.kash.infrastructure.persistence.mapper;

import es.enyavi.kash.domain.model.Person;
import es.enyavi.kash.infrastructure.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toDomain(PersonEntity entity);
    PersonEntity toEntity(Person domain);
}
