package ec.mjaramillo.administrador.model.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mjaramillo.administrador.exception.ResourceNotFoundException;
import ec.mjaramillo.administrador.model.entity.Administrador;
import ec.mjaramillo.administrador.model.repository.AdministradorRepository;
import ec.mjaramillo.administrador.model.service.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Override
	public Administrador crear(Administrador administrador) {
		Administrador existeAdministrador = null;
		try {
			existeAdministrador = administradorRepository.findOneByCedula(administrador.getCedula());
			if (existeAdministrador != null) {
				return editar(existeAdministrador.getCedula(), administrador);
			}else {
				administradorRepository.save(administrador);
				return administrador;
			}
	
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Administrador editar(String cedula, Administrador administrador) {
		Administrador existeAdministrador = obtenerPorIdentificacion(cedula);
		
		if (administrador.getApellidos()!= null ) { existeAdministrador.setApellidos(administrador.getApellidos()); }
		if (administrador.getContrasena()!= null ) { existeAdministrador.setContrasena(administrador.getContrasena()); }
		if (administrador.getNombres()!= null ) { existeAdministrador.setNombres(administrador.getNombres()); }
		if (administrador.getUsuario()!= null ) { existeAdministrador.setUsuario(administrador.getUsuario()); }
		
		administradorRepository.save(existeAdministrador);
		return existeAdministrador;
	}

	@Override
	public Administrador obtenerPorIdentificacion(String cedula) {
		return (Administrador) Optional.ofNullable(administradorRepository.findOneByCedula(cedula))
				.orElseThrow(() ->  
				new ResourceNotFoundException("Administrador no encontrado con la cedula numero : " + cedula)
		);
	}

	@Override
	public Administrador eliminar(String cedula) {
		Administrador existeAdministrador = obtenerPorIdentificacion(cedula);
		administradorRepository.delete(existeAdministrador);
		return existeAdministrador;
	}

}
