package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Personas;

public class PersonasConsultar {
	
@SuppressWarnings("unchecked")
public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Personas.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			//Consulta de todos registros
			miSession.beginTransaction();
			List <Personas> lasPersonas = miSession.createQuery("from Personas").getResultList();
			recorrePersonas(lasPersonas);
			
			//Consulta: dame los Arias
			System.out.println("\nMuestra Apellido Arias ----------------------------------------------------------------/");
			lasPersonas = miSession.createQuery("from Personas per where per.apellidos='Arias'").getResultList();
			recorrePersonas(lasPersonas);
			
			//Consulta: dame los Guedez y direccion maternidad
			System.out.println("\nMuestra Apellido y direccion especifica ----------------------------------------------------------------/");
			lasPersonas = miSession.createQuery("from Personas per where per.apellidos='Guedez' or per.direccion='Maternidad P'").getResultList();
			recorrePersonas(lasPersonas);
			
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			miFactory.close();
			System.out.println("Terminado!!!");
		}

	}	//end method main

	private static void recorrePersonas(List<Personas> lasPersonas) {
		for (Personas unaPersona:lasPersonas) {
			System.out.println(unaPersona);
		}	//mostrar registros
	}

}