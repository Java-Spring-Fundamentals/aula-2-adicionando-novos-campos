package com.example.crud.domain.product;

import com.example.crud.domain.product.enums.DistributionCenterEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();
    List<Product> findAllByActiveTrueAndDistributionCenter(DistributionCenterEnum distributionCenter);
    long countAllByActiveTrueAndDistributionCenter(DistributionCenterEnum distributionCenter);
}