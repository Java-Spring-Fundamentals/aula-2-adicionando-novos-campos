package com.example.crud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(
        String id,
<<<<<<< HEAD

=======
>>>>>>> 2e6fda9 (Adicionando o campo distributionCenter á atividade)
        @NotBlank
        String name,
        @NotNull
        Integer price,
        @NotBlank
<<<<<<< HEAD
        String category
=======
        String category,
        @NotNull
        DistributionCenter distributionCenter
>>>>>>> 2e6fda9 (Adicionando o campo distributionCenter á atividade)
) {
}
