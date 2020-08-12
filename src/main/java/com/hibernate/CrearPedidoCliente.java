package com.hibernate;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.modelo.Cliente;
import com.hibernate.modelo.DetallesCliente;
import com.hibernate.modelo.Pedido;

public class CrearPedidoCliente {

	public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
																					 .addAnnotatedClass(DetallesCliente.class)
																					 .addAnnotatedClass(Pedido.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			Cliente elCliente = miSession.get(Cliente.class, 2);
			//Cliente elCliente = miSession.get(Cliente.class, 2);	//Obtener el cliente especifico
			
			Pedido pedido1 = new Pedido(new GregorianCalendar (2020,7,5));	//Se crean 3 pedidos
			Pedido pedido2 = new Pedido(new GregorianCalendar (2020,6,15));
			Pedido pedido3 = new Pedido(new GregorianCalendar (2020,4,25));
			
			elCliente.agregarPedidos(pedido1);	//Agregar pedidos al cliente
			elCliente.agregarPedidos(pedido2);
			elCliente.agregarPedidos(pedido3);
			
			miSession.save(pedido1);	//Guarda los pedidos en la tabla pedido
			miSession.save(pedido2);
			miSession.save(pedido3);
			
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en la BBDD");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miSession.close();
			miFactory.close();
			System.out.println("Terminado!!!");
		}
	}	//end method main

}	//end class