package ru.itis.servletlesson.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.servletlesson.mapper.CategoryMapper;
import ru.itis.servletlesson.mapper.ProductMapper;
import ru.itis.servletlesson.mapper.UserMapper;
import ru.itis.servletlesson.mapper.impl.CategoryMapperImpl;
import ru.itis.servletlesson.mapper.impl.ProductMapperImpl;
import ru.itis.servletlesson.mapper.impl.UserMapperImpl;
import ru.itis.servletlesson.model.ProductEntity;
import ru.itis.servletlesson.repository.CategoryRepository;
import ru.itis.servletlesson.repository.ProductRepository;
import ru.itis.servletlesson.repository.UserRepository;
import ru.itis.servletlesson.repository.impl.CategoryRepositoryImpl;
import ru.itis.servletlesson.repository.impl.ProductRepositoryImpl;
import ru.itis.servletlesson.repository.impl.UserRepositoryImpl;
import ru.itis.servletlesson.service.CategoryService;
import ru.itis.servletlesson.service.ProductService;
import ru.itis.servletlesson.service.impl.CategoryServiceImpl;
import ru.itis.servletlesson.service.impl.ProductServiceImpl;
import ru.itis.servletlesson.utils.PropertyReader;

import javax.sql.DataSource;

@Slf4j
@WebListener
public class MainContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();

        DataSource dataSource = dataSource();
        context.setAttribute("dataSource", dataSource);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        context.setAttribute("jdbcTemplate", jdbcTemplate);

        ProductMapper productMapper = new ProductMapperImpl();
        context.setAttribute("productMapper", productMapper);

        CategoryMapper categoryMapper = new CategoryMapperImpl();
        context.setAttribute("categoryMapper", categoryMapper);

        UserMapper userMapper = new UserMapperImpl();
        context.setAttribute("userMapper", userMapper);

        CategoryRepository categoryRepository = new CategoryRepositoryImpl(jdbcTemplate, categoryMapper);
        context.setAttribute("categoryRepository", categoryRepository);

        ProductRepository productRepository = new ProductRepositoryImpl(jdbcTemplate, categoryRepository, productMapper);
        context.setAttribute("productRepository", productRepository);

        UserRepository userRepository = new UserRepositoryImpl(jdbcTemplate, userMapper);
        context.setAttribute("userRepository", userRepository);

        CategoryService categoryService = new CategoryServiceImpl(categoryRepository, categoryMapper);
        context.setAttribute("categoryService", categoryService);

        ProductService productService = new ProductServiceImpl(productRepository, productMapper);
        context.setAttribute("productService", productService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("-=-=-=-=-=-=-=-=- CONTEXT DESTROYED -==-=-=-=-=-=-=-=-=");
    }

    private DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(PropertyReader.getProperty("DB_URL"));
        dataSource.setUser(PropertyReader.getProperty("DB_USER"));
        dataSource.setPassword(PropertyReader.getProperty("DB_PASSWORD"));
        return dataSource;
    }
}
