package com.hibernate.configuracion;

import com.hibernate.implementacion.ConexionVacia;
import com.hibernate.implementacion.ConexionMySQL_Impl;
import com.hibernate.implementacion.ConexionOracle_Impl;
import com.hibernate.interfaces.IConexion;

public class ConexionFabrica {

	public IConexion getConexion(String motor) {
		if (motor == null) {
			return new ConexionVacia();
			
		} else if (motor.equalsIgnoreCase("MYSQL")) {
			return new ConexionMySQL_Impl();
			
		} else if (motor.equalsIgnoreCase("ORACLE")) {
			return new ConexionOracle_Impl();
		}
		return new ConexionVacia();
	}
	
}