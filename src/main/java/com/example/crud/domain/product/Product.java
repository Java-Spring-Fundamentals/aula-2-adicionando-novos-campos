package com.example.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price;

<<<<<<< HEAD
=======
    @Enumerated(EnumType.STRING)
    @Column(name="distribution_center")
    private DistributionCenter distributionCenter;

>>>>>>> 2e6fda9 (Adicionando o campo distributionCenter á atividade)
    private Boolean active;

    private String category;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price = requestProduct.price();
        this.category = requestProduct.category();
<<<<<<< HEAD
        this.active = true;
=======
        this.distributionCenter= requestProduct.distributionCenter();
        this.active = true;


>>>>>>> 2e6fda9 (Adicionando o campo distributionCenter á atividade)
    }
}
