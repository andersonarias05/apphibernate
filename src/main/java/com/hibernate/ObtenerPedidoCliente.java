package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Cliente;
import com.hibernate.modelo.DetallesCliente;
import com.hibernate.modelo.Pedido;

public class ObtenerPedidoCliente {

	public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
																					 .addAnnotatedClass(DetallesCliente.class)
																					 .addAnnotatedClass(Pedido.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			Cliente elCliente = miSession.get(Cliente.class, 2);	//Obtener el cliente especifico
			
			System.out.println("Cliente: "+elCliente);
			System.out.println("Pedidos: "+elCliente.getPedidos());
			
			miSession.getTransaction().commit();
			System.out.println("Se obtiene los registros correctamente de la BBDD");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miSession.close();
			miFactory.close();
			System.out.println("Terminado!!!");
		}
	}	//end method main

}	//end class