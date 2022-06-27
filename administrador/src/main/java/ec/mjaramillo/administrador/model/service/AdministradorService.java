package ec.mjaramillo.administrador.model.service;

import ec.mjaramillo.administrador.model.entity.Administrador;

public interface AdministradorService {
	public Administrador crear(Administrador administrador);
	public Administrador editar(String cedula, Administrador administrador);
	public Administrador obtenerPorIdentificacion(String cedula);
	public Administrador eliminar(String cedula);
}
