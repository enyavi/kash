package es.enyavi.kash.infrastructure.persistence.mapper;

import es.enyavi.kash.domain.model.Category;
import es.enyavi.kash.infrastructure.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toDomain(CategoryEntity entity);
    CategoryEntity toEntity(Category domain);
}