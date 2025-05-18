package ru.itis.servletlesson.service;

import ru.itis.servletlesson.dto.request.CategoryRequest;
import ru.itis.servletlesson.dto.request.NewProductRequest;
import ru.itis.servletlesson.dto.response.ListProductsResponse;

import java.util.List;

public interface ProductService {

//    ListProductsResponse getAllProducts(Long userId);
    ListProductsResponse getAllProducts();

    void saveNewProduct(NewProductRequest request, List<CategoryRequest> requestList);

}
