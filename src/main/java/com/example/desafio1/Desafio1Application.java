package com.example.desafio1;


import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio1.services.Cliente;
import com.example.desafio1.services.ClienteServiceI;
import com.example.desafio1.services.Contrato;
import com.example.desafio1.services.ContratoI;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner{
	@Autowired
	private ClienteServiceI clienteServiceI;
	private ContratoI contratoI;
	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {	
		//Clientes
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("JoséAntonio");
		cliente1.setApellido1("Ramos");
		cliente1.setApellido2("Chamorro");	
		cliente1.setDni("123456789");	
		clienteServiceI.insertar(cliente1);
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Antonio");
		cliente2.setApellido1("Ramos");
		cliente2.setApellido2("Chamorro");	
		cliente2.setDni("187654329");	
		clienteServiceI.insertar(cliente2);

		
		//Operaciones Clientes
		//Modificar
		cliente2.setDni("987654321");
		clienteServiceI.modificar(cliente2);
		//Conssultapor ID
		clienteServiceI.findById(cliente2.getId());

		clienteServiceI.listaTodo();
		//Contratos
		Contrato contrato1 = new Contrato(Date.valueOf("2021-01-01"),Date.valueOf("2021-12-12"),10.5);
		Contrato contrato2 = new Contrato(Date.valueOf("2021-12-12"),Date.valueOf("2022-01-01"),20.0);
		cliente1.setContratos(new ArrayList<Contrato>());
		cliente1.addContrato(contrato1);
		cliente1.addContrato(contrato2);
		//Operaciones Contratos
	}}
