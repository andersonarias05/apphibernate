package com.hibernate.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hibernate.interfaces.IConexion;

public class ConexionMySQL_Impl implements IConexion {
	
	private String url;
	private String usuario;
	private String contrasena;
	Connection miconexion;

	public ConexionMySQL_Impl() {
		//this.url = "jdbc:mysql://localhost:3306/appspring?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; MySQL8
		this.url = "jdbc:mysql://localhost:3306/appspring?useSSL=false"; //MySQL5
		this.usuario = "harryustiz";
		this.contrasena = "18912394";
	}	//fin constructor

	@Override
	public void conectar() {
		try {
			System.out.println("Intentando conectar con la BBDD: "+url);
			//Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); MySQL8
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection(url, usuario, contrasena);  
			System.out.println("Conexion exitosa a Mysql!!");
		} catch(Exception e) {
			System.out.println("Error al conectar con la base de datos de MySQL (Fallido!!)");
			e.printStackTrace();
		}
	}

	@Override
	public void desconectar() {
		try {
			miconexion.close();
			System.out.println("Se desconecta de MySQLBD exitoso!");
		} catch (SQLException e) {
			System.out.println("Error al desconectar con la base de datos de MySQL (Fallido!!)");
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ConexionMySQL_Impl [url=" + url + ", usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}
	
}