package com.hibernate;

import com.hibernate.configuracion.ConexionFabrica;
import com.hibernate.interfaces.IConexion;

public class PruebaJDBC {
	
	public static void main(String[] args) {
		ConexionFabrica fabrica = new ConexionFabrica();
		/*
		IConexion cx1 = fabrica.getConexion("ORACLE");
		cx1.conectar();
		cx1.desconectar();
		*/
		IConexion cx2 = fabrica.getConexion("MYSQL");
		cx2.conectar();
		cx2.desconectar();
		
	}

}