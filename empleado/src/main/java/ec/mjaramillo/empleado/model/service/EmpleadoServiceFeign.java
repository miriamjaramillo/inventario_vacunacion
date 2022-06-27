package ec.mjaramillo.empleado.model.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ec.mjaramillo.empleado.clientes.AdministradorClienteRest;
import ec.mjaramillo.empleado.exception.ResourceNotFoundException;
import ec.mjaramillo.empleado.model.entity.Administrador;
import ec.mjaramillo.empleado.model.entity.Empleado;
import ec.mjaramillo.empleado.model.respository.EmpleadoRepository;

@Primary
@Service("serviceAdministradorFeign")
public class EmpleadoServiceFeign implements EmpleadoService {

	@Autowired
	private AdministradorClienteRest administradorFeign;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public Administrador obtenerAdminPorCedula(String cedula) {
		return administradorFeign.obtenerPorIdentificacion(cedula);
	}

	@Override
	public Empleado crear(Empleado empleado, String cedulaAdmin) {
		Calendar calendar = Calendar.getInstance();
		Administrador existeAdministrador = obtenerAdminPorCedula(cedulaAdmin);
		Empleado existeEmpleado = Optional.ofNullable(empleadoRepository.findOneByCedula(empleado.getCedula())).orElse(null);
		
		if(existeEmpleado != null) {
			throw new ResourceNotFoundException("Ya existe el empleado con el numero de cedula : " + empleado.getCedula());
		}
		
		empleado.setFechaRegistro(calendar.getTime());
		empleado.setAdministrador(existeAdministrador);
		return empleadoRepository.save(empleado);	
	}

	@Override
	public Empleado editar(String cedula, Empleado empleado) {
		
		Empleado existeEmpleado = obtenerPorIdentificacion(cedula);
		
		if (null == existeEmpleado) {
			throw new ResourceNotFoundException("La cedula del empleado a modificar no existe.");
		}else {
			if (!empleado.getNombres().isEmpty() && empleado.getNombres() != null) {existeEmpleado.setNombres(empleado.getNombres());};
			if (!empleado.getApellidos().isEmpty() && empleado.getApellidos() != null) {existeEmpleado.setApellidos(empleado.getApellidos());};
			if (!empleado.getContrasena().isEmpty() && empleado.getContrasena() != null) {existeEmpleado.setContrasena(empleado.getContrasena());};
			if (!empleado.getCorreoElectronico().isEmpty() && empleado.getCorreoElectronico() != null) {existeEmpleado.setCorreoElectronico(empleado.getCorreoElectronico());};
			if (!empleado.getDireccion().isEmpty() && empleado.getDireccion() != null) {existeEmpleado.setDireccion(empleado.getDireccion());};
			if (empleado.getFechaNacimiento() != null) {existeEmpleado.setFechaNacimiento(empleado.getFechaNacimiento());};
			if (!empleado.getTelefono().isEmpty() && empleado.getTelefono() != null) {existeEmpleado.setTelefono(empleado.getTelefono());};
			if (!empleado.getUsuario().isEmpty() && empleado.getUsuario() != null) {existeEmpleado.setUsuario(empleado.getUsuario());};
			
			empleadoRepository.save(existeEmpleado);
		}
		
		return existeEmpleado;
	}

	@Override
	public Empleado obtenerPorIdentificacion(String cedula) {
		return (Empleado) Optional.ofNullable(empleadoRepository.findOneByCedula(cedula))
				.orElseThrow(() ->  
				new ResourceNotFoundException("Empleado con el numero de cedula : " + cedula + " no encontrado.")
		);
	}

	@Override
	public Empleado eliminar(String cedula) {
		Empleado empleado = obtenerPorIdentificacion(cedula);
		empleadoRepository.delete(empleado);
		return empleado;
	}

	@Override
	public List<Empleado> listar() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado darAlta(String usuario, String contrasena, String cedulaEmpleado) {
		
		Empleado existeEmpleado = obtenerPorIdentificacion(cedulaEmpleado);
		
		if (null == existeEmpleado) {
			throw new ResourceNotFoundException("La cedula del empleado a modificar no existe.");
		}else {
			if (!usuario.isEmpty() && usuario != null) {existeEmpleado.setUsuario(usuario);};
			if (!contrasena.isEmpty() && contrasena != null ) {existeEmpleado.setContrasena(contrasena);};
			
			empleadoRepository.save(existeEmpleado);
		}
		
		return existeEmpleado;
	}
	
}

