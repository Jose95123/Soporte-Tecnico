package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reparacion")
public class Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReparacion;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo; 
    
    @Column(name="fecha_reparacion")
    private LocalDate fechaReparacion;
    
    @Column(name="costo")
    private BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado; 

    @ManyToOne
    @JoinColumn(name = "id_garantia")
    private Garantia garantia; 

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name="fecha_entrega")
    private LocalDate fechaEntrega;

    public Reparacion() {
    }

    public Reparacion(Equipo equipo, LocalDate fechaReparacion, BigDecimal costo,
                      Empleado empleado, Garantia garantia, LocalDate fechaEntrega) {
        this.equipo = equipo;
        this.fechaReparacion = fechaReparacion;
        this.costo = costo;
        this.empleado = empleado;
        this.garantia = garantia;
        this.fechaEntrega = fechaEntrega;
    }

	public Long getIdReparacion() {
		return idReparacion;
	}

	public void setIdReparacion(Long idReparacion) {
		this.idReparacion = idReparacion;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public LocalDate getFechaReparacion() {
		return fechaReparacion;
	}

	public void setFechaReparacion(LocalDate fechaReparacion) {
		this.fechaReparacion = fechaReparacion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Garantia getGarantia() {
		return garantia;
	}

	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


}
