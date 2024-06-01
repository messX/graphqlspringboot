package com.example.graphql.services;

import com.example.graphql.entity.Product;
import com.example.graphql.mapper.IProductMapper;
import com.example.graphql.model.ProductModel;
import com.example.graphql.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService implements IProductService{

    @Autowired
    IProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional
    public Product create(ProductModel productModel) {
        return productRepository.save(productMapper.productModelToProduct(productModel));
    }

    @Override
    public List<Product> getAll(Pageable pageable) {
        Page<Product> pagedData = productRepository.findAll(pageable);
        return pagedData.stream().toList();
    }

    @Override
    public Product get(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid product id"));
    }

    @Override
    @Transactional
    public Product update(ProductModel productModel) {
        return productRepository.save(productMapper.productModelToProduct(productModel));
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new RuntimeException("Name not found!"));
    }
}
