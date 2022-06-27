package ec.mjaramillo.inventario.model.service;

import ec.mjaramillo.inventario.model.entity.Vacuna;

public interface VacunaService {
	public Vacuna crear(Vacuna vacuna);
	public Vacuna editar(Long id, Vacuna vacuna);
	public Vacuna obtenerPorId(Long id);
	public Vacuna eliminar(Long id);
}
