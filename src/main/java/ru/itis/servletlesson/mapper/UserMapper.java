package ru.itis.servletlesson.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.servletlesson.dto.request.SignUpRequest;
import ru.itis.servletlesson.dto.response.UserDataResponse;
import ru.itis.servletlesson.model.UserEntity;

public interface UserMapper extends RowMapper<UserEntity> {

    UserEntity toEntity(SignUpRequest request);

    UserDataResponse toDto(UserEntity entity);
}
