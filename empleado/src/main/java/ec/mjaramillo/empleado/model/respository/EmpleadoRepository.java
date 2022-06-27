package ec.mjaramillo.empleado.model.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.mjaramillo.empleado.model.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	public Empleado findOneByCedula(String cedula);
}
