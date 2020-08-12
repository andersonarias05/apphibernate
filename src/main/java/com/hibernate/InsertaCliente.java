package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Cliente;
import com.hibernate.modelo.DetallesCliente;
import com.hibernate.modelo.Pedido;

public class InsertaCliente {

	public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
																					 .addAnnotatedClass(Pedido.class)
																					 .addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			Cliente cliente1 = new Cliente("Harry","Arias","Venezuela");
			DetallesCliente detallesCliente1 = new DetallesCliente("www.harry.com","04268185238","Segundo Cliente");
			
			cliente1.setDetalleCliente(detallesCliente1);	//Asocio los objetos
			
			miSession.beginTransaction();
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en la BBDD");
			miSession.close();
		} finally {
			miFactory.close();
			System.out.println("Terminado!!!");
		}
	}	//end method main

}	//end class