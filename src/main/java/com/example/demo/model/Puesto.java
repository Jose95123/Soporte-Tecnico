package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "puestos")
public class Puesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPuesto;

	@Column(name = "nombre_puesto")
	private String nombrePuesto;

	public Puesto() {
	}

	public Puesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public Long getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(Long idPuesto) {
		this.idPuesto = idPuesto;
	}

	public String getNombrePuesto() {
		return nombrePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
}
