package ru.itis.servletlesson.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.servletlesson.dto.response.ListCategoriesResponse;
import ru.itis.servletlesson.dto.response.ListProductsResponse;
import ru.itis.servletlesson.service.CategoryService;
import ru.itis.servletlesson.service.ProductService;

import java.io.IOException;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private ProductService productService;
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();

        productService = (ProductService) servletContext.getAttribute("productService");
        categoryService = (CategoryService) servletContext.getAttribute("categoryService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

//        UserDataResponse user = (UserDataResponse) session.getAttribute("user");

        ListProductsResponse listProductsResponse = productService.getAllProducts();
        ListCategoriesResponse listCategoriesResponse = categoryService.getAllCategories();

        session.setAttribute("products", listProductsResponse);
        session.setAttribute("categories", listCategoriesResponse);

        req.getRequestDispatcher("jsp/products.jsp").forward(req, resp);
    }
}
