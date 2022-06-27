package ec.mjaramillo.inventario.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ec.mjaramillo.inventario.clientes.EmpleadoClienteRest;
import ec.mjaramillo.inventario.dto.EmpleadoReporte;
import ec.mjaramillo.inventario.exception.ResourceNotFoundException;
import ec.mjaramillo.inventario.model.entity.Empleado;
import ec.mjaramillo.inventario.model.entity.EmpleadoVacuna;
import ec.mjaramillo.inventario.model.entity.EmpleadoVacunaId;
import ec.mjaramillo.inventario.model.entity.Vacuna;
import ec.mjaramillo.inventario.model.repository.EmpleadoRepository;
import ec.mjaramillo.inventario.model.repository.EmpleadoVacunaRepository;
import ec.mjaramillo.inventario.model.repository.VacunaRepository;

@Primary
@Service("serviceInventarioFeign")
public class EmpleadoVacunaServiceFeign implements EmpleadoVacunaService{

	@Autowired
	private EmpleadoClienteRest empleadoFeign;
	@Autowired
	private VacunaRepository vacunaRepository;
	@Autowired
	private EmpleadoVacunaRepository empleadoVacunaRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public Empleado obtenerEmpleadoPorCedula(String cedula) {
		return empleadoFeign.obtenerPorIdentificacion(cedula);
	}

	@Override
	public EmpleadoVacuna editar(String cedula, Long idVacuna, EmpleadoVacuna empleadoVacuna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoVacuna eliminar(String cedula, Long idVacuna) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EmpleadoVacuna crear(String cedula, Long idVacuna, EmpleadoVacuna empleadoVacuna, int numeroDosis) {
		
		Empleado existeEmpleado = obtenerEmpleadoPorCedula(cedula);
		Vacuna existeVacuna = vacunaRepository.findById(idVacuna).orElseThrow(() ->  
			new ResourceNotFoundException("Vacuna con el id: " + idVacuna + " no encontrada")
		);
		
		EmpleadoVacunaId idEmpleadoVacuna = new EmpleadoVacunaId(existeEmpleado.getEmpleadoId(), existeVacuna.getVacunaId(), numeroDosis);
		EmpleadoVacuna existeEmpleadoVacuna = empleadoVacunaRepository.findById(idEmpleadoVacuna).orElse(null);
		
		if (existeEmpleadoVacuna == null) {
			
			existeEmpleadoVacuna = new EmpleadoVacuna(idEmpleadoVacuna, existeEmpleado, existeVacuna, 
					empleadoVacuna.getFechaVacunacion(), numeroDosis);
			empleadoVacunaRepository.saveAll(Arrays.asList(existeEmpleadoVacuna));
		}else {
			throw new ResourceNotFoundException("Informacion ya existente.");
		}
		
		return null;
	}

	@Override
	public EmpleadoVacuna obtenerDatosVacuna(String cedula, Long idVacuna, int numeroDosis) {
		Empleado existeEmpleado = obtenerEmpleadoPorCedula(cedula);
		
		Vacuna existeVacuna = vacunaRepository.findById(idVacuna).orElseThrow(() ->  
			new ResourceNotFoundException("Vacuna con el id: " + idVacuna + " no encontrada")
		);
		
		EmpleadoVacunaId idEmpleadoVacuna = new EmpleadoVacunaId(existeEmpleado.getEmpleadoId(), existeVacuna.getVacunaId(), numeroDosis);
		
		return empleadoVacunaRepository.findById(idEmpleadoVacuna).orElseThrow(() ->  
			new ResourceNotFoundException("No existe informacion para los datos ingresados.")
		);
	}

	@Override
	public List<EmpleadoReporte> empleadosVacunados() {
		List<Object[]> rows = Optional.ofNullable(empleadoRepository.empleadosVacunados())
				.orElseThrow(() ->  
				new ResourceNotFoundException("No existen empleados vacunados.")
		);
		
		List<EmpleadoReporte> result = new ArrayList<>(rows.size());
		for (Object[] row : rows) {
		    result.add(new EmpleadoReporte((String) row[0],(String) row[1],
		    		(String) row[2],(String) row[3],(String) row[4],(int) row[5],(Date) row[6]));
		}
		
		return result;
	}

	@Override
	public List<EmpleadoReporte> empleadosNoVacunados() {
		List<Object[]> rows = Optional.ofNullable(empleadoRepository.empleadosNoVacunados())
				.orElseThrow(() ->  
				new ResourceNotFoundException("No existen empleados no vacunados.")
		);
		
		List<EmpleadoReporte> result = new ArrayList<>(rows.size());
		for (Object[] row : rows) {
		    result.add(new EmpleadoReporte((String) row[0],(String) row[1],
		    		(String) row[2],(String) row[3]));
		}
		
		return result;
	}

	@Override
	public List<EmpleadoReporte> empleadosPorFecha(Date fechaInicio, Date fechaFin) {
		List<Object[]> rows = Optional.ofNullable(empleadoRepository.empleadosPorFecha(fechaInicio, fechaFin))
				.orElseThrow(() ->  
				new ResourceNotFoundException("No existen en ese rango de fechas.")
		);
		
		List<EmpleadoReporte> result = new ArrayList<>(rows.size());
		for (Object[] row : rows) {
		    result.add(new EmpleadoReporte((String) row[0],(String) row[1],
		    		(String) row[2],(String) row[3],(String) row[4],(int) row[5],(Date) row[6]));
		}
		
		return result;
	}

	@Override
	public List<EmpleadoReporte> empleadosPorTipoVacuna(String tipo) {
		List<Object[]> rows = Optional.ofNullable(empleadoRepository.empleadosPorTipoVacuna(tipo))
				.orElseThrow(() ->  
				new ResourceNotFoundException("No existen con el tipo de vacuna " + tipo)
		);
		
		List<EmpleadoReporte> result = new ArrayList<>(rows.size());
		for (Object[] row : rows) {
		    result.add(new EmpleadoReporte((String) row[0],(String) row[1],
		    		(String) row[2],(String) row[3],(String) row[4],(int) row[5],(Date) row[6]));
		}
		
		return result;
	}

}
