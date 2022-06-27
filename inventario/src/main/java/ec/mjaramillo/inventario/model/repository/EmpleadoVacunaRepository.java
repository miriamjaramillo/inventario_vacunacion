package ec.mjaramillo.inventario.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.mjaramillo.inventario.model.entity.EmpleadoVacuna;
import ec.mjaramillo.inventario.model.entity.EmpleadoVacunaId;

public interface EmpleadoVacunaRepository extends JpaRepository<EmpleadoVacuna, EmpleadoVacunaId>{
}
