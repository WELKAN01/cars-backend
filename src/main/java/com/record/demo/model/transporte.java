package com.record.demo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

//herencia
@Getter
@MappedSuperclass
@Setter
@NoArgsConstructor
public class transporte {
    private String modelo;
    private String marca;
    private String color;

    public transporte(String modelo, String marca, String color) {
        this.modelo=modelo;
        this.marca=marca;
        this.color=color;
    }
}
