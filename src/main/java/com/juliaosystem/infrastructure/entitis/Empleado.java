package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Entity
@DiscriminatorValue("Empleado")
@Builder
public class Empleado extends User {

    @Override
    public int getMaxDiasPrestados() {
        return 7;
    }
}