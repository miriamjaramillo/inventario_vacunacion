package ec.mjaramillo.empleado.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.mjaramillo.empleado.model.entity.Empleado;
import ec.mjaramillo.empleado.model.service.EmpleadoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {

	@Autowired
	private EmpleadoService empleadoService;
	
	@ApiOperation(value = "Permite crear un empleado", notes = "Previo a la creacion del empleado verifica la existencia por el numero de cedula", tags = { "Empleado" })
	@RequestMapping(value = "/crear/{cedulaAdministrador}", method = RequestMethod.POST)
    public ResponseEntity<?> crear(@PathVariable(value = "cedulaAdministrador") String cedulaAdministrador, @RequestBody Empleado empleadoRequest){
        Empleado empleado = empleadoService.crear(empleadoRequest, cedulaAdministrador);
        return new ResponseEntity<>(empleado,HttpStatus.CREATED);
    }
	
	@ApiOperation(value = "Actualiza un empleado", notes = "Actualiza un empleado por su numero de cedula", tags = { "Empleado" })
	@PutMapping("/editar/{cedula}")
	public ResponseEntity<?> editar(@PathVariable(value = "cedula") String cedula, @RequestBody Empleado empleadoRequest){
		Empleado empleado = empleadoService.editar(cedula, empleadoRequest);
		return ResponseEntity.ok(empleado);
	}
	
	@ApiOperation(value = "Devuelve un empleado", notes = "Devuelve un empleado por el numero de cedula", tags = { "Empleado" })
	@GetMapping("/obtener/{cedula}")
	public Empleado obtenerPorIdentificacion(@PathVariable(value = "cedula")  String cedula) {
		Empleado empleado =  empleadoService.obtenerPorIdentificacion(cedula);		
		return empleado;
	}
	
	@ApiOperation(value = "Elimina un empleado", notes = "Elimina un empleado por el numero de cedula", tags = { "Empleado" })
	@DeleteMapping("/eliminar/{cedula}")
	public Map<String, Boolean> eliminar(@PathVariable(value = "cedula") String cedula) {
		empleadoService.eliminar(cedula);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Estado eliminacion: ", Boolean.TRUE);
		return response;
	}
}
