package ru.itis.servletlesson.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.servletlesson.service.Calculator;
import ru.itis.servletlesson.service.impl.CalculatorImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "calculator", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private Calculator calculator;

    public void init() {
        calculator = new CalculatorImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("value1"));
        int b = Integer.parseInt(req.getParameter("value2"));

        int result = calculator.sum(a,b);

        PrintWriter out = resp.getWriter();

        out.println("<html><body");
        out.println("<h1> Result: " + result + "</h1>");
        out.println("</body></html>");


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
