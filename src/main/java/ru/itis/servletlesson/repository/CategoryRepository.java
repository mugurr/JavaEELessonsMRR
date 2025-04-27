package ru.itis.servletlesson.repository;

import ru.itis.servletlesson.dto.request.CategoryRequest;
import ru.itis.servletlesson.model.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Integer addCategoryAndGetId(String categoryName);

    Optional<Integer> findCategoryByName(String categoryName);

    List<CategoryEntity> findCategoriesByProductId(Long productId);

    void saveProductCategories(Long productId, List<CategoryRequest> categories);

    Optional<CategoryEntity> findCategoryById(Long id);

    List<CategoryEntity> getAllCategories();
}
