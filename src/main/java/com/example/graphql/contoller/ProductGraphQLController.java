package com.example.graphql.contoller;

import com.example.graphql.entity.Product;
import com.example.graphql.model.ProductModel;
import com.example.graphql.services.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class ProductGraphQLController {
    @Autowired
    IProductService productService;

    @MutationMapping
    public Product saveProduct(@Argument ProductModel product) {
        log.info(String.format("Received product request for product name : %s", product.getName()));
        return productService.create(product);
    }

    @QueryMapping
    public Product product(@Argument int id) {
        return productService.get(id);
    }

    @MutationMapping
    public Product updateProduct(@Argument ProductModel product) {
        return productService.update(product);
    }

    @QueryMapping
    public List<Product> products(@Argument int size, @Argument int page) {
        log.info(String.format("Getting all products for page %d and size %d", page, size));
        Pageable paging = PageRequest.of(page, size);
        return productService.getAll(paging);
    }

    @QueryMapping
    public Product getProductByName(@Argument String name) {
        log.info(String.format("Getting products for name %s", name));
        return productService.getByName(name);
    }

}
