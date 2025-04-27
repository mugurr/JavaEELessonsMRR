package ru.itis.servletlesson.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.itis.servletlesson.dto.response.CategoryResponse;
import ru.itis.servletlesson.dto.response.ListCategoriesResponse;
import ru.itis.servletlesson.mapper.CategoryMapper;
import ru.itis.servletlesson.model.CategoryEntity;
import ru.itis.servletlesson.repository.CategoryRepository;
import ru.itis.servletlesson.service.CategoryService;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public ListCategoriesResponse getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.getAllCategories();
        if (categories.isEmpty()) {
            return new ListCategoriesResponse(Collections.emptyList());
        }
        return categoryMapper.toDto(categories);
    }
}
