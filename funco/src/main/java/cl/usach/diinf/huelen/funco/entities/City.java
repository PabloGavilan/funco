package cl.usach.diinf.huelen.funco.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the City database table.
 * 
 */
@Entity
@Table(name="City")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idCity;

	@Column(nullable=false, length=45)
	private String nameCity;

	public City() {
	}

	public int getIdCity() {
		return this.idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getNameCity() {
		return this.nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

}