package ec.mjaramillo.administrador.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.mjaramillo.administrador.model.entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	public Administrador findOneByCedula(String cedula);
}
