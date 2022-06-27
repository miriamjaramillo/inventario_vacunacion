package ec.mjaramillo.administrador.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.mjaramillo.administrador.model.entity.Administrador;
import ec.mjaramillo.administrador.model.service.AdministradorService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;
	
	@ApiOperation(value = "Permite crear o editar un administrador", notes = "Verifica la existencia de la cedula de identidad", tags = { "Administrador" })
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Administrador administradorRequest) {
		Administrador administrador = administradorService.crear(administradorRequest);
		return new ResponseEntity<>(administrador,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Actualiza un administrador", notes = "Actualiza un administrador por su numero de cedula", tags = { "Administrador" })
	@PutMapping("/editar/{cedula}")
	public ResponseEntity<?> editar(@PathVariable(value = "cedula") String cedula, @RequestBody Administrador administradorRequest){
		Administrador administrador = administradorService.editar(cedula, administradorRequest);
		return ResponseEntity.ok(administrador);
	}
	
	@ApiOperation(value = "Devuelve un administrador", notes = "Devuelve un administrador por el numero de cedula", tags = { "Administrador" })
	@GetMapping("/obtener/{cedula}")
	public Administrador obtenerPorIdentificacion(@PathVariable(value = "cedula")  String cedula) {
		Administrador administrador =  administradorService.obtenerPorIdentificacion(cedula);		
		return administrador;
	}
	
	@ApiOperation(value = "Elimina un administrador", notes = "Elimina un administrador por el numero de cedula", tags = { "Administrador" })
	@DeleteMapping("/eliminar/{cedula}")
	public Map<String, Boolean> eliminar(@PathVariable(value = "cedula") String cedula) {
		administradorService.eliminar(cedula);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Estado eliminacion: ", Boolean.TRUE);
		return response;
	}
}
