package com.example.desafio1.services;

import java.util.List;

public interface ClienteServiceI {
	public void insertar(Cliente cliente);
	public List<Cliente> listaTodo();	
	public void modificar(Cliente cliente);
	public void eliminar(Cliente cliente);
	public Cliente findById(Long id);

}
