package ec.mjaramillo.administrador.model.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class EmpleadoVacunaId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "empleado_id")
    private Long empleadoId;

    @Column(name = "vacuna_id")
    private Long vacunaId;
    
    public EmpleadoVacunaId() {
    	
	}

	public EmpleadoVacunaId(Long empleadoId, Long vacunaId) {
		this.empleadoId = empleadoId;
		this.vacunaId = vacunaId;
	}

	public Long getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
	}

	public Long getVacunaId() {
		return vacunaId;
	}

	public void setVacunaId(Long vacunaId) {
		this.vacunaId = vacunaId;
	}
    
	
}
