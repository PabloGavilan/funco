package cl.usach.diinf.huelen.funco.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Esta clase de persistencia corresponde a un registro de la tabla usuario.
 * @author Pablo Gavilan
 */
@Entity @Table(name="Usuario") @NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String SQL_SELECT_ALL = "Usuario.findAll";

	@Id @Column(name="usu_id", length=8) @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
	@Column(name="usu_rut", length=8)     private String rut;
	@Column(name="usu_dv", length=1)      private String dv;
	@Column(name="usu_nom", length=40)    private String nombre;
	@Column(name="usu_app", length=40)    private String apPaterno;
	@Column(name="usu_apm", length=40)    private String apMaterno;
	@Column(name="usu_fec_nac", length=8) private String fecNacimiento;
	@Column(name="usu_pass", length=10)   private String clave;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDv() {
		return this.dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getNombr() {
		return this.nombre;
	}

	public void setNombr(String nombr) {
		this.nombre = nombr;
	}

	public String getApPaterno() {
		return this.apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return this.apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getFecNacimiento() {
		return this.fecNacimiento;
	}

	public void setFecNacimiento(String fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override public String toString() {
		StringBuilder r = new StringBuilder();
		String nl = System.getProperty("line.separator");
		r.append(this.getClass().getName() + " Objeto {" + nl);
		r.append("id["+ this.id + "]\n");
		r.append("rut[" + this.rut+ "]\n");
		r.append("dv[" + this.dv+ "]\n");
		r.append("nombre[" + this.nombre+ "]\n");
		r.append("apPaterno[" + this.apPaterno+ "]\n");
		r.append("apMaterno[" + this.apMaterno+ "]\n");
		r.append("fecNacimiento[" + this.fecNacimiento+ "]\n");
		r.append("clave[" + this.clave + "]");
		return r.toString();
	}
}