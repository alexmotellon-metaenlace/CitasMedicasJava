package com.metaenlace.citasmedicas.models;

import javax.persistence.*;

@Entity
@Table(name = "pacientes" )
public class Paciente extends Usuario{

	private static final long serialVersionUID = 1L;
    	
	@Column(name = "nss")
	public String nss;

    @Column(name = "numTarjeta")
	public String numTarjeta;

    @Column(name = "telefono")
	public String telefono;

    @Column(name = "direccion")
	public String direccion;

	public Paciente() {}

	public Paciente(Long id, String nombre, String apellidos, String nickUsuario, String clave, String nss, String numTarjeta, String telefono, String direccion) {
        super(id,nombre,apellidos,nickUsuario,clave);
		this.nss = nss;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getNss() {
		return this.nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNumTarjeta() {
		return this.numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
