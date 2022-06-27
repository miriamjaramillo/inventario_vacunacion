package ec.mjaramillo.inventario.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name =  "administrador_id", unique = true  , nullable = false)
	@TableGenerator(name="entidad_generadora",
	    table="id_gen",
	    pkColumnName="nombre",
	    valueColumnName="valor",
	    pkColumnValue="administrador_id",
	    initialValue=0,
	    allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,
			generator = "entidad_generadora")
	private Long administradorId;
	@Pattern(regexp = "^0[1-9]|[1-9]\\d {10}", message = "Formato de la cedula incorrecto")
	@NotBlank(message = "La cedula es obligatoria")
	@Column(name ="cedula", unique = true, nullable=false)
	private String cedula;
	@Column(name ="nombres", nullable=false)
	private String nombres;
	@Column(name ="apellidos", nullable=false)
	private String apellidos;
	@Column(name ="usuario", unique=true, nullable=false)
	private String usuario;
	@Column(name ="contrasena", nullable=false)
	private String contrasena;
	
	@JsonIgnore
	@OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Empleado> empleados = new HashSet<>();
	
	public Administrador() {
		
	}
	
	public Administrador(Long administradorId, String nombres, String apellidos, String usuario, String contrasena) {
		super();
		this.administradorId = administradorId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public Long getAdministradorId() {
		return administradorId;
	}
	
	public void setAdministradorId(Long administradorId) {
		this.administradorId = administradorId;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
}
