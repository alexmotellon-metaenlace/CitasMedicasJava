package com.metaenlace.citasmedicas.models;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "citas" )
public class Cita implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "id")
	public Long id;

    @Column(name = "fechaHora")
	public Date fechaHora;

    @Column(name = "motivoCita")
	public String motivoCita;

    @Column(name = "attribute11")
	public Long attribute11;

	@OneToOne
    @JoinColumn(name = "medico")
	public Medico medico;
	
	@OneToOne
    @JoinColumn(name = "paciente")
	public Paciente paciente;

	public Cita() {}
	
	public Cita(Long id, Date fechaHora, String motivoCita, Long attribute11, Medico medico, Paciente paciente) {
		this.id = id;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.attribute11 = attribute11;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}
	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public Long getAttribute11() {
		return attribute11;
	}
	public void setAttribute11(Long attribute11) {
		this.attribute11 = attribute11;
	}

	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

    public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
