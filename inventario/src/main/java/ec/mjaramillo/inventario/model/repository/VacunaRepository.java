package ec.mjaramillo.inventario.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.mjaramillo.inventario.model.entity.Vacuna;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Long>{

}
