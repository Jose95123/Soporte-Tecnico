package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "garantia")
public class Garantia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGarantia;

    @Column(name="duracion_meses")
    private int duracionMeses;

    public Garantia() {
    }

    public Garantia(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public Long getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Long idGarantia) {
        this.idGarantia = idGarantia;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }
}
