package com.example.crud.domain.product;

import com.example.crud.domain.product.enums.DistributionCenterEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(
        String id,

        @NotBlank
        String name,
        @NotNull
        Integer price,
        @NotBlank
        String category,
        @NotNull
        DistributionCenterEnum distributionCenter
) {
}
