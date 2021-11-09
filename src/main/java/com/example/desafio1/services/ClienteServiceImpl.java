package com.example.desafio1.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteServiceImpl implements ClienteServiceI {
	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);

		session.save(cliente);
		session.close();

	}
	@Override
	public List<Cliente> listaTodo() {
		 Session session = entityManager.unwrap(Session.class);
    ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.createQuery("FROM Cliente").list();
        System.out.println("Listar todos");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("Nombre: " + listaClientes.get(i).getNombre() 
            		+ " Apellidos: " + listaClientes.get(i).getApellido1() 
            		+ " " + listaClientes.get(i).getApellido2()
            		+ " DNI: " + listaClientes.get(i).getDni());
        }

		session.close();
		return listaClientes;
	}

	@Override
	@Transactional
	public void modificar(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(cliente);
		session.close();

	}
	@Override
	public void eliminar(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);

		session.delete(cliente);
		session.close();

	}

	@Override
	public Cliente findById(Long id) {
		  Session session = entityManager.unwrap(Session.class);

	        Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE id=" + id).uniqueResult();
	        System.out.println("Listar 1");
	        System.out.println("Nombre: " + cliente.getNombre() 
	        + " Apellidos: " + cliente.getApellido1() 
	        + " " + cliente.getApellido2()
	        + " DNI: "+ cliente.getDni());
	        
	        session.close();;
		return cliente;
	}

}
