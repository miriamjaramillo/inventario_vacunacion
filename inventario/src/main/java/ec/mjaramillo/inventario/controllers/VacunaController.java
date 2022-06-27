package ec.mjaramillo.inventario.controllers;

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

import ec.mjaramillo.inventario.model.entity.Vacuna;
import ec.mjaramillo.inventario.model.service.VacunaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vacuna")
public class VacunaController {

	@Autowired
	private VacunaService vacunaService;
	
	@ApiOperation(value = "Permite crear un objeto de tipo vacuna", notes = "Crea un objeto de tipo vacuna", tags = { "Vacuna" })
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Vacuna vacunaRequest) {
		Vacuna vacuna = vacunaService.crear(vacunaRequest);
		return new ResponseEntity<>(vacuna,HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Actualizar un objeto vacuna", notes = "Permite actualizar un objeto vacuna dado su id", tags = { "Vacuna" })
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@PathVariable(value = "id") Long id, @RequestBody Vacuna vacunaRequest){
		Vacuna vacuna = vacunaService.editar(id, vacunaRequest);
		return ResponseEntity.ok(vacuna);
	}
	
	@ApiOperation(value = "Devuelve informacion de una vacuna", notes = "Devuelve informacion de una vacuna dado su id", tags = { "Vacuna" })
	@GetMapping("/obtener/{id}")
	public Vacuna obtenerPorId(@PathVariable(value = "id")  Long id) {
		Vacuna vacuna =  vacunaService.obtenerPorId(id);		
		return vacuna;
	}
	
	@ApiOperation(value = "Elimina una vacuna", notes = "Elimina una vacuna dado su id", tags = { "Vacuna" })
	@DeleteMapping("/eliminar/{id}")
	public Map<String, Boolean> eliminar(@PathVariable(value = "id") Long id) {
		vacunaService.eliminar(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Estado eliminacion: ", Boolean.TRUE);
		return response;
	}
}
