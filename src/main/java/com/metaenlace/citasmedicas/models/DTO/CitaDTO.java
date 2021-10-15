package com.metaenlace.citasmedicas.models.DTO;
import java.io.Serializable;

public class CitaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fechaHora; // yyyy-MM-dd HH:mm:ss
	private String motivoCita;
	private Long attribute11;
	private Long paciente;
	private Long medico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
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

	public Long getPaciente() {
		return paciente;
	}
	public void setPaciente(Long paciente) {
		this.paciente = paciente;
	}
	
	public Long getMedico() {
		return medico;
	}
	public void setMedico(Long medico) {
		this.medico = medico;
	}
}
