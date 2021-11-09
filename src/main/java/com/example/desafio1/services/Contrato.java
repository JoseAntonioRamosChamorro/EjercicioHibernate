package com.example.desafio1.services;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRATO")
public class Contrato {
	private long id;
	private Date fechaVigencia;
	private Date fechaCaducidad;
	private Double precioMensual;
	private Cliente cliente;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTRATO", nullable = false, precision = 15)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FECHA_VIGENCIA")
	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	@Column(name = "FECHA_CADUCIDAD")
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Column(name = "PRECIO_MENSUAL")
	public Double getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(Double precioMensual) {
		this.precioMensual = precioMensual;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Contrato(Long id, Date fechaVigencia, Date fechaCaducidad, Double precioMensual, Cliente cliente) {
		super();
		this.id = id;
		this.fechaVigencia = fechaVigencia;
		this.fechaCaducidad = fechaCaducidad;
		this.precioMensual = precioMensual;
		this.cliente = cliente;
	}

	public Contrato(Date fechaVigencia, Date fechaCaducidad, Double precioMensual) {
		super();
		this.fechaVigencia = fechaVigencia;
		this.fechaCaducidad = fechaCaducidad;
		this.precioMensual = precioMensual;
	}

}
