package com.record.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class carro extends transporte{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre_carro;
    private int puertas;

    public carro(int id, String nombre_carro, int puertas, String modelo, String marca, String color) {
        super(modelo,marca,color);
        this.id=id;
        this.nombre_carro=nombre_carro;
        this.puertas=puertas;
    }
}
