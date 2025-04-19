package ru.itis.servletlesson.dto.request;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private String name;
}
