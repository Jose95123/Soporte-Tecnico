package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipo;
	@Column(name = "nombre_equipo")
	private String nombreEquipo;

	@Column(name = "modelo")
	private String modelo;

	@ManyToOne
	@JoinColumn(name = "tipo_reparacion_id")
	private TipoReparacion tipoReparacion;

	@ManyToOne
	@JoinColumn(name = "garantia_id")
	private Garantia garantia;

	public Equipo() {
	}

	public Equipo(String nombreEquipo, String modelo, TipoReparacion tipoReparacion, Garantia garantia) {
		this.nombreEquipo = nombreEquipo;
		this.modelo = modelo;
		this.tipoReparacion = tipoReparacion;
		this.garantia = garantia;
	}

	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoReparacion getTipoReparacion() {
		return tipoReparacion;
	}

	public void setTipoReparacion(TipoReparacion tipoReparacion) {
		this.tipoReparacion = tipoReparacion;
	}

	public Garantia getGarantia() {
		return garantia;
	}

	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}
}
