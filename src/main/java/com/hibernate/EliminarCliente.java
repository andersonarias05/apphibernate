package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Cliente;
import com.hibernate.modelo.DetallesCliente;

public class EliminarCliente {
	
public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
																					 .addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			Cliente elCliente = miSession.get(Cliente.class, 2);
			if(elCliente!=null) {
				System.out.println("Eliminando el cliente: "+elCliente.getNombre());
				miSession.delete(elCliente);
			}
			
			miSession.getTransaction().commit();
			if(elCliente!=null) {
				System.out.println("Registro eliminado correctamente en la BBDD");
			} else {
				System.out.println("Nada que eliminar");
			}
			
			miSession.close();
		} finally {
			miFactory.close();
			System.out.println("Terminado!!!");
		}
	}	//end method main

}