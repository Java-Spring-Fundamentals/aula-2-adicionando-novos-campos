package com.example.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();
<<<<<<< HEAD
=======

    List<Product> findAllByTrueAndDistributionCenter(DistributionCenter distributionCenter);

>>>>>>> 2e6fda9 (Adicionando o campo distributionCenter á atividade)
}