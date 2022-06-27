package ec.mjaramillo.inventario.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.mjaramillo.inventario.model.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	@Query(value = "select distinct(e.cedula), e.nombres, e.apellidos, e.telefono, v.tipo, ev.numero_dosis, ev.fecha_vacunacion from empleado e"
			+ " inner join empleado_vacuna ev on e.empleado_id = ev.empleado_id "
			+ " inner join vacuna v on ev.vacuna_id = v.vacuna_id", nativeQuery = true)
	public List<Object[]> empleadosVacunados();
	
	@Query(value = "select distinct(e.cedula), e.nombres, e.apellidos, e.telefono "
			+ " from empleado e where e.cedula not in(select distinct(e.cedula) from empleado e "
			+ " inner join empleado_vacuna ev on e.empleado_id = ev.empleado_id inner join vacuna v on ev.vacuna_id = v.vacuna_id)", nativeQuery = true)
	public List<Object[]> empleadosNoVacunados();
	
	@Query(value = "select distinct(e.cedula), e.nombres, e.apellidos, e.telefono, v.tipo, ev.numero_dosis, ev.fecha_vacunacion "
			+ " from empleado e inner join empleado_vacuna ev on e.empleado_id = ev.empleado_id "
			+ " inner join vacuna v on ev.vacuna_id = v.vacuna_id where ev.fecha_vacunacion between :fechaInicio and :fechaFin", nativeQuery = true)
	public List<Object[]> empleadosPorFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
	
	@Query(value = "select distinct(e.cedula), e.nombres, e.apellidos, e.telefono, v.tipo, ev.numero_dosis, ev.fecha_vacunacion "
			+ " from empleado e inner join empleado_vacuna ev on e.empleado_id = ev.empleado_id "
			+ " inner join vacuna v on ev.vacuna_id = v.vacuna_id where v.tipo = :tipo", nativeQuery = true)
	public List<Object[]> empleadosPorTipoVacuna(@Param("tipo") String tipo);
}
