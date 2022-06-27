package ec.mjaramillo.inventario.model.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.mjaramillo.inventario.exception.ResourceNotFoundException;
import ec.mjaramillo.inventario.model.entity.Vacuna;
import ec.mjaramillo.inventario.model.repository.VacunaRepository;
import ec.mjaramillo.inventario.model.service.VacunaService;

@Service
public class VacunaServiceImpl implements VacunaService{

	@Autowired
	private VacunaRepository vacunaRepository;
	
	@Override
	public Vacuna crear(Vacuna vacuna) {
		Vacuna nuevaVacuna = new Vacuna(vacuna.getTipo(), vacuna.getDescripcion());
		return vacunaRepository.save(nuevaVacuna);
	}

	@Override
	public Vacuna editar(Long id, Vacuna vacuna) {
		Vacuna existeVacuna = obtenerPorId(id);
		existeVacuna.setDescripcion(vacuna.getDescripcion());
		existeVacuna.setTipo(vacuna.getTipo());
		return vacunaRepository.save(existeVacuna);
	}

	@Override
	public Vacuna obtenerPorId(Long id) {
		return vacunaRepository.findById(id).orElseThrow(() ->  
			new ResourceNotFoundException("Vacuna con el id: " + id + " no encontrada")
		);
	}

	@Override
	public Vacuna eliminar(Long id) {
		Vacuna existeVacuna = obtenerPorId(id);
		vacunaRepository.delete(existeVacuna);
		return existeVacuna;
	}

}
