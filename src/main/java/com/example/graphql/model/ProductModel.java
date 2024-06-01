package com.example.graphql.model;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductModel {
    private String name;
    private String description;
    private String status;
    private String currency;
    private Double price;
    private List<String> imageUrls;
    private List<String> videoUrls;
    private Integer stock;

}
