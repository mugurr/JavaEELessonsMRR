package ru.itis.servletlesson.dto.response;

import lombok.*;
import ru.itis.servletlesson.model.CategoryEntity;

import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantity;

    private String image;

    private List<CategoryEntity> category;
}
