package ec.mjaramillo.empleado.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ec.mjaramillo.empleado.model.entity.Administrador;

@FeignClient(name="administrador.mjaramilloapis.ec", url="localhost:8001")
public interface AdministradorClienteRest {
	@GetMapping("/administrador/obtener/{cedula}")
	public Administrador obtenerPorIdentificacion(@PathVariable(value = "cedula")  String cedula);
}
