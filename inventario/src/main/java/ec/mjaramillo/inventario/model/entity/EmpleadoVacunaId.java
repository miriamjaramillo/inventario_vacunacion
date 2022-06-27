package ec.mjaramillo.inventario.model.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class EmpleadoVacunaId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "empleado_id")
    private Long empleadoId;

    @Column(name = "vacuna_id")
    private Long vacunaId;
    
    @Column(name = "numero_dosis")
    private int numeroDosis;
    
    public EmpleadoVacunaId() {
    	
	}

	public EmpleadoVacunaId(Long empleadoId, Long vacunaId, int numeroDosis) {
		this.empleadoId = empleadoId;
		this.vacunaId = vacunaId;
		this.numeroDosis = numeroDosis;
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

	public int getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}
    
}
