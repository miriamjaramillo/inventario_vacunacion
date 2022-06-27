package ec.mjaramillo.inventario.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ec.mjaramillo.inventario.model.entity.Empleado;

@FeignClient(name="empleado.mjaramilloapis.ec", url="localhost:8002")
public interface EmpleadoClienteRest {

	@GetMapping("/empleado/obtener/{cedula}")
	public Empleado obtenerPorIdentificacion(@PathVariable(value = "cedula")  String cedula);
}
