package com.plansoft.marulo_market.persistence.mapper;

import com.plansoft.marulo_market.domain.Category;
import com.plansoft.marulo_market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // Convierte de Categoria (entity) a Category (domain)
    @Mappings({
            @Mapping(source = "idCategoria", target = "caterogyId"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
