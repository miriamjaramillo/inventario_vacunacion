package ec.mjaramillo.administrador.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name =  "empleado_id", unique = true  , nullable = false)
	@TableGenerator(name="entidad_generadora",
	    table="id_gen",
	    pkColumnName="nombre",
	    valueColumnName="valor",
	    pkColumnValue="empleado_id",
	    initialValue=0,
	    allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,
			generator = "entidad_generadora")
	private Long empleadoId;
	@Column(name ="cedula", unique=true, nullable=false)
	private String cedula;
	@Column(name ="nombres", nullable=false)
	private String nombres;
	@Column(name ="apellidos", nullable=false)
	private String apellidos;
	@Column(name ="correo_electronico", nullable=false)
	private String correo_electronico;
	@Column(name ="fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name ="direccion")
	private String direccion;
	@Column(name ="telefono")
	private String telefono;
	@Column(name ="usuario")
	private String usuario;
	@Column(name ="contrasena")
	private String contrasena;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "administrador_id",
			referencedColumnName = "administrador_id",
			updatable = false, nullable = false)
	private Administrador administrador;
	
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmpleadoVacuna> empleadoVacunas = new HashSet<>();
	
	public Empleado() {
	}
	
	public Empleado(String cedula, String nombres, String apellidos, String correo_electronico, Date fechaNacimiento,
			String direccion, String telefono) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo_electronico = correo_electronico;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Long getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
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

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	
}
