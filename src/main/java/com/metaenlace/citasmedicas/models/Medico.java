package com.metaenlace.citasmedicas.models;

import javax.persistence.*;

@Entity
@Table(name = "medicos" )
public class Medico extends Usuario {

	private static final long serialVersionUID = 1L;
	
    @Column(name = "numColegiado")
	public String numColegiado;
	
	public Medico() {}

	public Medico(Long id, String clave, String nombre, String apellidos, String nickUsuario, String numColegiado) {
        super(id,clave,nombre,apellidos,nickUsuario);
		this.numColegiado = numColegiado;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

}
