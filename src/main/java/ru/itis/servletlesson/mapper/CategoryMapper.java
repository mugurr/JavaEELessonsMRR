package ru.itis.servletlesson.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.servletlesson.dto.response.ListCategoriesResponse;
import ru.itis.servletlesson.model.CategoryEntity;

import java.util.List;

public interface CategoryMapper extends RowMapper<CategoryEntity> {
    ListCategoriesResponse toDto(List<CategoryEntity> categories);
}
