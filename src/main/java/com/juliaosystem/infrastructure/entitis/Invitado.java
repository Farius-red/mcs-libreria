package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Entity
@DiscriminatorValue("INVITADO")
@Builder
public class Invitado extends User {

    @Override
    public int getMaxDiasPrestados() {
        return 5;
    }
}