package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Cliente;
import com.hibernate.modelo.DetallesCliente;

public class ObtenerCliente {
	
	public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				 																	 .addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			DetallesCliente detallesDeCliente = miSession.get(DetallesCliente.class, 3);
			System.out.println("Tabla detalles: "+detallesDeCliente);
			System.out.println("Tabla clientes: "+detallesDeCliente.getCliente());
			
			System.out.println("Ahora se elimina en cascada /--------------");
			miSession.delete(detallesDeCliente);

			miSession.getTransaction().commit();
			System.out.println("Registro la consulta correctamente en la BBDD");
			miSession.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			miSession.close();
			miFactory.close();
			System.out.println("Terminado!!!");
		}
			
	}	//end method main

}