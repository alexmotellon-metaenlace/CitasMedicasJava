package com.metaenlace.citasmedicas.models;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "usuarios" )
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	public String nombre;
	
	@Column(name = "apellidos")
	public String apellidos;
	
	@Column(name = "nickUsuario")
	public String nickUsuario;
    
	@Column(name = "clave")
	public String clave;

	public Usuario() {}
	
	public Usuario(Long id, String clave, String nombre, String apellidos, String nickUsuario) {
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickUsuario = nickUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNickUsuario() {
		return nickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}

}
