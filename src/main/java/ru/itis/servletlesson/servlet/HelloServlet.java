package ru.itis.servletlesson.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.itis.servletlesson.service.Calculator;
import ru.itis.servletlesson.service.impl.CalculatorImpl;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private Calculator calculator;

    public void init() {
        calculator = new CalculatorImpl();
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //автоматическая реализация
//        int a = Integer.parseInt(request.getParameter("a"));
//        int b = Integer.parseInt(request.getParameter("b"));
        int a;
        int b;
        a = 4;
        b = 6;
        int result = calculator.sum(a, b);

//        //реализация с видео
//        int a = Integer.getInteger(request.getQueryString());
//        int b = Integer.getInteger(request.getQueryString());
//        int result = calculator.sum(a, b);



        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + result + "</h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}