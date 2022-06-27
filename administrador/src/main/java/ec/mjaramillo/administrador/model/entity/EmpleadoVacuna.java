package ec.mjaramillo.administrador.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "empleado_vacuna")
public class EmpleadoVacuna implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private EmpleadoVacunaId id;
	
	@ManyToOne
    @MapsId("empleadoId")
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
	
	@ManyToOne
    @MapsId("vacunaId")
    @JoinColumn(name = "vacuna_id")
    private Vacuna vacuna;
	
	@Column(name = "fecha_vacunacion")
    private Date fechaVacunacion;
	
	@Column(name = "numero_dosis")
    private int numeroDosis;
	
	public EmpleadoVacuna() {
	}

	public EmpleadoVacuna(EmpleadoVacunaId id, Empleado empleado, Vacuna vacuna, Date fechaVacunacion) {
		this.id = new EmpleadoVacunaId(empleado.getEmpleadoId(), vacuna.getVacunaId());
		this.empleado = empleado;
		this.vacuna = vacuna;
		this.fechaVacunacion = fechaVacunacion;
	}

	public EmpleadoVacunaId getId() {
		return id;
	}

	public void setId(EmpleadoVacunaId id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public int getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}
}
