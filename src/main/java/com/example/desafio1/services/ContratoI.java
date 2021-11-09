package com.example.desafio1.services;

import java.util.List;

public interface ContratoI {
public Long insertarContrato(Contrato contrato);
	
	public List<Contrato> searchAll();
	
	public Contrato searchById(Long id);
	
	public void actualizarContrato(Contrato contrato);
	
	public void eliminarContrato(Contrato contrato);
}
