package ec.mjaramillo.inventario.model.service;

import java.util.Date;
import java.util.List;

import ec.mjaramillo.inventario.dto.EmpleadoReporte;
import ec.mjaramillo.inventario.model.entity.Empleado;
import ec.mjaramillo.inventario.model.entity.EmpleadoVacuna;

public interface EmpleadoVacunaService {
	
	public Empleado obtenerEmpleadoPorCedula(String cedula);
	public EmpleadoVacuna crear(String cedula, Long idVacuna, EmpleadoVacuna empleadoVacuna, int numeroDosis);
	public EmpleadoVacuna editar(String cedula, Long idVacuna, EmpleadoVacuna empleadoVacuna);
	public EmpleadoVacuna obtenerDatosVacuna(String cedula, Long idVacuna, int numeroDosis);
	public EmpleadoVacuna eliminar(String cedula, Long idVacuna);
	
	public List<EmpleadoReporte> empleadosVacunados();
	public List<EmpleadoReporte> empleadosNoVacunados();
	public List<EmpleadoReporte> empleadosPorFecha(Date fechaInicio, Date fechaFin);
	public List<EmpleadoReporte> empleadosPorTipoVacuna(String tipo);
}
