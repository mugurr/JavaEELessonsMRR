package ru.itis.servletlesson.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.servletlesson.dto.request.NewProductRequest;
import ru.itis.servletlesson.dto.response.ListProductsResponse;
import ru.itis.servletlesson.model.ProductEntity;

import java.util.List;

public interface ProductMapper extends RowMapper<ProductEntity> {
    ProductEntity toEntity(NewProductRequest request);
    ListProductsResponse toDto(List<ProductEntity> entity);

}
