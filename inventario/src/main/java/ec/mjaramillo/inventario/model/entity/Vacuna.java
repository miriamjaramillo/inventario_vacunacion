package ec.mjaramillo.inventario.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "vacuna")
public class Vacuna implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name =  "vacuna_id", unique = true  , nullable = false)
	@TableGenerator(name="entidad_generadora",
	    table="id_gen",
	    pkColumnName="nombre",
	    valueColumnName="valor",
	    pkColumnValue="vacuna_id",
	    initialValue=0,
	    allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,
			generator = "entidad_generadora")
	private Long vacunaId;
	@Column(name ="tipo", unique=true, nullable=false)
	private String tipo;
	@Column(name ="descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "vacuna")
    private Set<EmpleadoVacuna> empleadoVacunas = new HashSet<>();
	
	public Vacuna() {
	}
	
	public Vacuna(String tipo, String descripcion) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public Long getVacunaId() {
		return vacunaId;
	}

	public void setVacunaId(Long vacunaId) {
		this.vacunaId = vacunaId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
