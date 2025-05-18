package ru.itis.servletlesson.service;

import ru.itis.servletlesson.dto.response.ListCategoriesResponse;

public interface CategoryService {
    ListCategoriesResponse getAllCategories();
}
