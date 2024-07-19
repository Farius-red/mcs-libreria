package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;

@Entity
@DiscriminatorValue("Afiliado")
@Builder
public class Afiliado extends User {

    @Override
    public int getMaxDiasPrestados() {
        return 10;
    }
}