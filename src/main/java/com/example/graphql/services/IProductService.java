package com.example.graphql.services;

import com.example.graphql.entity.Product;
import com.example.graphql.model.ProductModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Product create(ProductModel productModel);
    List<Product> getAll(Pageable pageable);
    Product get(Integer id);
    Product update(ProductModel productModel);

    Product getByName(String name);
}
