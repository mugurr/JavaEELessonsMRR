package ru.itis.servletlesson.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itis.servletlesson.dto.request.CategoryRequest;
import ru.itis.servletlesson.dto.request.NewProductRequest;
import ru.itis.servletlesson.dto.response.ListProductsResponse;
import ru.itis.servletlesson.mapper.ProductMapper;
import ru.itis.servletlesson.model.ProductEntity;
import ru.itis.servletlesson.repository.ProductRepository;
import ru.itis.servletlesson.service.ProductService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
//    public ListProductsResponse getAllProducts(Long userId) {
    public ListProductsResponse getAllProducts() {
//        List<ProductEntity> products = productRepository.getAllProducts(userId);
        List<ProductEntity> products = productRepository.getAllProducts();
        log.info("Get all products");

        if (products.isEmpty()) {
            return new ListProductsResponse(Collections.emptyList());
        }
        return productMapper.toDto(products);
    }

    @Override
    public void saveNewProduct(NewProductRequest request, List<CategoryRequest> requestList) {
        Optional<ProductEntity> optionalProduct = productRepository.saveNewProduct(productMapper.toEntity(request), requestList);

    }
}
