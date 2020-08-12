package com.hibernate.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hibernate.interfaces.IConexion;

public class ConexionOracle_Impl implements IConexion {

	private String url;
	private String usuario;
	private String contrasena;
	Connection miconexion;

	public ConexionOracle_Impl() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.usuario = "system";
		this.contrasena = "18912394";
	}	//fin constructor

	@Override
	public void conectar() {
		try {
			System.out.println("Intentando conectar con la BBDD: "+url);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			miconexion = DriverManager.getConnection(url, usuario, contrasena);  
			System.out.println("Conexion exitosa a Oracle11g!!");
		} catch(Exception e) {
			System.out.println("Error al conectar con la base de datos de Oracle11g (Fallido!!)");
			e.printStackTrace();
		}
	}
	
	@Override
	public void desconectar() {
		try {
			miconexion.close();
			System.out.println("Se desconecta de Oracle11g exitoso!");
		} catch (SQLException e) {
			System.out.println("Error al desconectar con la base de datos de Oracle11g (Fallido!!)");
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ConexionOracle_Impl [url=" + url + ", usuario=" + usuario + ", contrasena=" + contrasena + ", miconexion=" + miconexion + "]";
	}

}