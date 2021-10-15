package com.metaenlace.citasmedicas.models.DTO;

public class PacienteDTO extends UsuarioDTO{

	private String nss;
	private String numTarjeta;
	private String telefono;
	private String direccion;


	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
