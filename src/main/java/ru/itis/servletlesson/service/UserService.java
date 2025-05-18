package ru.itis.servletlesson.service;

import ru.itis.servletlesson.dto.request.SignInRequest;
import ru.itis.servletlesson.dto.request.SignUpRequest;
import ru.itis.servletlesson.dto.response.AuthResponse;
import ru.itis.servletlesson.dto.response.UserDataResponse;

public interface UserService {
    AuthResponse signUp(SignUpRequest request);

    AuthResponse signIn(SignInRequest request);

    AuthResponse checkAdmin(UserDataResponse user);
}
