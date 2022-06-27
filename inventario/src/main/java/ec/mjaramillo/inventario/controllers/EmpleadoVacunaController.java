package ec.mjaramillo.inventario.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.mjaramillo.inventario.dto.EmpleadoReporte;
import ec.mjaramillo.inventario.model.entity.EmpleadoVacuna;
import ec.mjaramillo.inventario.model.service.EmpleadoVacunaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/empleado_vacuna")
public class EmpleadoVacunaController {

	@Autowired
	private EmpleadoVacunaService empleadoVacunaService;
	
	@ApiOperation(value = "Registrar vacuna al empleado", notes = "Permite registrar las vacunas de los empleados", tags = { "Empleado Vacuna" })
	@PostMapping("/crear/{cedula}/{idVacuna}/{numDosis}")
	public ResponseEntity<?> crear(@PathVariable(value = "cedula") String cedula, @PathVariable(value = "idVacuna") Long idVacuna, 
			@PathVariable(value = "numDosis") int numDosis, @RequestBody EmpleadoVacuna empleadoVacunaRequest) {
		EmpleadoVacuna empleadoVacuna = empleadoVacunaService.crear(cedula, idVacuna, empleadoVacunaRequest, numDosis);
		return new ResponseEntity<>(empleadoVacuna,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Empleados vacunados", notes = "Listar empleados vacunados", tags = { "Reportes" })
	@GetMapping("/empleadosVacunados")
	public List<EmpleadoReporte> listarEmpleadosVacunados() {
		List<EmpleadoReporte> listaEmpleados = empleadoVacunaService.empleadosVacunados();
		return listaEmpleados;
	}
	
	@ApiOperation(value = "Empleados no vacunados", notes = "Listar empleados no vacunados", tags = { "Reportes" })
	@GetMapping("/empleadosNoVacunados")
	public List<EmpleadoReporte> listarEmpleadosNoVacunados() {
		List<EmpleadoReporte> listaEmpleados = empleadoVacunaService.empleadosNoVacunados();
		return listaEmpleados;
	}
	
	@ApiOperation(value = "Empleados vacunados en un rango de fecha", notes = "Listar empleados vacunados en un rango de fecha ingresado", tags = { "Reportes" })
	@GetMapping("/empleadosPorFecha/{fechaInicio}/{fechaFin}")
	public List<EmpleadoReporte> empleadosPorFecha(@PathVariable(value = "fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
			@PathVariable(value = "fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
		List<EmpleadoReporte> listaEmpleados = empleadoVacunaService.empleadosPorFecha(fechaInicio, fechaFin);
		return listaEmpleados;
	}
	
	@ApiOperation(value = "Empleados vacunados en un rango de fecha", notes = "Listar empleados vacunados en un rango de fecha ingresado", tags = { "Reportes" })
	@GetMapping("/empleadosPorTipoVacuna/{tipo}")
	public List<EmpleadoReporte> empleadosPorFecha(@PathVariable(value = "tipo") String tipo) {
		List<EmpleadoReporte> listaEmpleados = empleadoVacunaService.empleadosPorTipoVacuna(tipo);
		return listaEmpleados;
	}
}
