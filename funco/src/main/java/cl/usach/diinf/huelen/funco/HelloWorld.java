package cl.usach.diinf.huelen.funco;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import cl.usach.diinf.huelen.funco.dao.UsuarioDAO;
import cl.usach.diinf.huelen.funco.entities.City;

@Named
@RequestScoped
public class HelloWorld {
	
	private EntityManager entityManager;
	
	private String helloWorld = "Hello World!!!";
	private int idCity;
	private String nameCity;

	public HelloWorld() {
		super();
	}
	
	@PostConstruct
	public void init(){
		this.entityManager = Persistence.createEntityManagerFactory("funco-pu").createEntityManager();
		City city = entityManager.createNamedQuery("City.findAll", City.class).getResultList().get(0);
		entityManager.close();
		this.idCity = city.getIdCity();
		this.nameCity = city.getNameCity();
		
		UsuarioDAO dao = new UsuarioDAO();
		try{
			dao.listUsuario();
		}catch(Exception e) {
			this.helloWorld = e.getMessage();
		}		
	}
	

	public String getHelloWorld() {
		return this.helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
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
