package ru.itis.servletlesson.mapper.impl;

import lombok.extern.slf4j.Slf4j;
import ru.itis.servletlesson.dto.request.SignUpRequest;
import ru.itis.servletlesson.dto.response.UserDataResponse;
import ru.itis.servletlesson.mapper.UserMapper;
import ru.itis.servletlesson.model.UserEntity;
import ru.itis.servletlesson.utils.AuthUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity toEntity(SignUpRequest request) {
        return UserEntity.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .hashPassword(AuthUtils.hashPassword(request.getPassword()))
                .role(request.getRole())
                .build();
    }

    @Override
    public UserDataResponse toDto(UserEntity entity) {
        return UserDataResponse.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .username(entity.getUsername())
                .role(entity.getRole())
                .build();
    }

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserEntity.builder()
                .id(rs.getLong("id"))
                .email(rs.getString("email"))
                .username(rs.getString("username"))
                .hashPassword(rs.getString("hash_password"))
                .role(rs.getString("role"))
                .build();
    }
}
