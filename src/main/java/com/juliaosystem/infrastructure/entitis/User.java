package com.juliaosystem.infrastructure.entitis;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@Table(name = "usuario")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo_usuario")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Invitado.class, name = "INVITADO")
})
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public abstract int getMaxDiasPrestados();
}
