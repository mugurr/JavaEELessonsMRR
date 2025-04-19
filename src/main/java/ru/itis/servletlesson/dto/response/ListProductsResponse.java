package ru.itis.servletlesson.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ListProductsResponse {

    List<ProductResponse> products;
}
