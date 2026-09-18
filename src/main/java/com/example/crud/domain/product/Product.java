package com.example.crud.domain.product;

import java.security.interfaces.DSAKey;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price;

    private Boolean active;

    private String category;

    @Enumerated(EnumType.STRING)
    @Column(name = "distribution_center", nullable = false)
    private DistributionCenter distributionCenter;

    public Product(RequestProduct requestProduct) {
        this.name = requestProduct.name();
        this.price = requestProduct.price();
        this.category = requestProduct.category();
        this.distributionCenter = requestProduct.distributionCenter();
        this.active = true;
    }
}