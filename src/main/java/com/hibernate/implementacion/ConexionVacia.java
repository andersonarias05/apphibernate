package com.hibernate.implementacion;

import com.hibernate.interfaces.IConexion;

public class ConexionVacia implements IConexion {

	@Override
	public void conectar() {
		System.out.println("NO SE ESPECIFICO PROVEEDOR");		
	}

	@Override
	public void desconectar() {
		System.out.println("NO SE ESPECIFICO PROVEEDOR");		
	}

}