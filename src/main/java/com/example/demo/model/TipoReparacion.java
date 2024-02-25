package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos_reparacion")
public class TipoReparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoReparacion;
    @Column(name="tipo")
    private String tipo;

    public TipoReparacion() {
    }

    public TipoReparacion(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdTipoReparacion() {
        return idTipoReparacion;
    }

    public void setIdTipoReparacion(Long idTipoReparacion) {
        this.idTipoReparacion = idTipoReparacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
