package ec.mjaramillo.inventario.dto;

import java.util.Date;

public class EmpleadoReporte {
	public String cedula;
	public String nombres;
	public String apellidos;
	public String telefono;
	public String tipoVacuna;
	public int numeroDosis;
	public Date fechaVacunacion;
	public String getCedula() {
		return cedula;
	}
	
	public EmpleadoReporte() {
		
	}
	
	public EmpleadoReporte(String cedula, String nombres, String apellidos, String telefono) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	
	public EmpleadoReporte(String cedula, String nombres, String apellidos, String telefono, String tipoVacuna,
			int numeroDosis, Date fechaVacunacion) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.tipoVacuna = tipoVacuna;
		this.numeroDosis = numeroDosis;
		this.fechaVacunacion = fechaVacunacion;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoVacuna() {
		return tipoVacuna;
	}
	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}
	public int getNumeroDosis() {
		return numeroDosis;
	}
	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}
	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}
	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

}
