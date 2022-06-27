package ec.mjaramillo.empleado.model.service;

import java.util.List;

import ec.mjaramillo.empleado.model.entity.Administrador;
import ec.mjaramillo.empleado.model.entity.Empleado;

public interface EmpleadoService {
	public Administrador obtenerAdminPorCedula(String cedula);
	public Empleado crear(Empleado empleado, String cedulaAdmin);
	public Empleado editar(String cedula, Empleado empleado);
	public Empleado obtenerPorIdentificacion(String cedula);
	public Empleado eliminar(String cedula);
	public Empleado darAlta(String usuario, String contrasena, String cedulaEmpleado);
	public List<Empleado> listar();
}
