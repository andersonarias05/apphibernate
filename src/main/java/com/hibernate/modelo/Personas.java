package com.hibernate.modelo;

import javax.persistence.*;

@Entity
@Table(name="personas")
public class Personas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="direccion")
	private String direccion;

	public Personas() {}

	public Personas(String nombres, String apellidos, String direccion) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Personas [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}
	
}