package ru.itis.servletlesson.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.servletlesson.dto.request.SignInRequest;
import ru.itis.servletlesson.dto.request.SignUpRequest;
import ru.itis.servletlesson.dto.response.AuthResponse;
import ru.itis.servletlesson.service.UserService;

import java.io.IOException;

import static ru.itis.servletlesson.model.UserEntity.USER_ROLE;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        userService = (UserService) context.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpRequest signUpRequest = SignUpRequest.builder()
                .email(req.getParameter("email"))
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .role(USER_ROLE)
                .build();

        AuthResponse authResponse = userService.signUp(signUpRequest);
        if (authResponse.getStatus() == 0) {
            resp.sendRedirect("/signIn");
        } else {
            resp.sendRedirect("/error?err=" + authResponse.getStatusDesc());
        }
    }
}
