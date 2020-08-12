package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Personas;

public class PersonasActualizar {
	
	public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Personas.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			//int personaId = 3;
			miSession.beginTransaction();
			/*Personas misPersonas = miSession.get(Personas.class, personaId);
			misPersonas.setNombres("Fabiana");
			misPersonas.setApellidos("Yustiz");*/
			
			miSession.createQuery("UPDATE Personas SET Apellidos ='Yustiz' WHERE Apellidos LIKE 'P%'").executeUpdate();	//Actualiza registro
			
			//miSession.createQuery("DELETE Personas WHERE Direccion = 'Maternidad P'").executeUpdate();	//Elimina registro
			
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			miFactory.close();
			System.out.println("Terminado!!!");
		}	//Actualiza registro
	
	}	//end method main

}