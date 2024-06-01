package com.example.graphql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private String customerId;
    private String status;
    private String address;
    @NotNull
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
}
