package ru.itis.servletlesson.mapper.impl;

import ru.itis.servletlesson.dto.response.CategoryResponse;
import ru.itis.servletlesson.dto.response.ListCategoriesResponse;
import ru.itis.servletlesson.mapper.CategoryMapper;
import ru.itis.servletlesson.model.CategoryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CategoryEntity.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .build();
    }

    @Override
    public ListCategoriesResponse toDto(List<CategoryEntity> entity) {
        List<CategoryResponse> categoryResponses = entity.stream()
                .map(catgory -> CategoryResponse.builder()
                        .id(catgory.getId())
                        .name(catgory.getName())
                        .build())
                .collect(Collectors.toList());

        return ListCategoriesResponse.builder()
                .categories(categoryResponses)
                .build();

    }

}
