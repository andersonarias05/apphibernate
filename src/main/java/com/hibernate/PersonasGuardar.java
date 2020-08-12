package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Personas;

public class PersonasGuardar {

	public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Personas.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			Personas personas1 = new Personas("Viviana","Guedez","Maternidad P");
			
			//Insercion de registros
			miSession.beginTransaction();
			miSession.save(personas1);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en la BBDD");
			
			//Lectura de registros
			miSession.beginTransaction();
			System.out.println("Lectura del registro con Id: "+personas1.getId());
			
			Personas personasInsertada = miSession.get(Personas.class, personas1.getId());
			System.out.println("Registro: "+personasInsertada);
			
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			miFactory.close();
			System.out.println("Terminado!!!");
		}

	}	//end method main

}	//end class GuardarCliente