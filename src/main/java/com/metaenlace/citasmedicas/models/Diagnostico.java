package com.metaenlace.citasmedicas.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "diagnosticos" )
public class Diagnostico implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	public Long id;
    
    @Column(name = "valoracion_especialista")
	public String valoracionEspecialista;

    @Column(name = "enfermedad")
	public String enfermedad;

	public Diagnostico() {}
	
	public Diagnostico(Long id, String valoracionEspecialista, String enfermedad) {
		this.id = id;
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
    public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}
	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

    public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
}
