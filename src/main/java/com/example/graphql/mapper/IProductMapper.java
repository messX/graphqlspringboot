package com.example.graphql.mapper;

import com.example.graphql.entity.Product;
import com.example.graphql.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    Product productModelToProduct(ProductModel productModel);
    ProductModel productToProductModel(Product product);
}
