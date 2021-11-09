package com.example.desafio1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio1.services.Cliente;
import com.example.desafio1.services.ClienteServiceI;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner{
	@Autowired
	private ClienteServiceI clienteServiceI;
	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {	
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

		//Modificar
		cliente2.setDni("987654321");
		clienteServiceI.modificar(cliente2);
		//Conssultapor ID
		clienteServiceI.findById(cliente2.getId());

		clienteServiceI.listaTodo();
	
	}}
