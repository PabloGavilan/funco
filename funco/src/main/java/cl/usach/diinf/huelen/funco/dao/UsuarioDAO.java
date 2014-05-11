package cl.usach.diinf.huelen.funco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.usach.diinf.huelen.funco.dao.impl.UsuarioIDAO;
import cl.usach.diinf.huelen.funco.entities.Usuario;

/**
 * <b>UsuarioDAO</b>
 * <p>
 * Clase encargada del acceso a la capa de datos para las funciones
 * relevantes para un usuario.
 * <p>
 * @author Pablo Gavilan
 * @version 1.0
 * @see UsuarioIDAO
 */
public class UsuarioDAO implements UsuarioIDAO{

	/**
	 * Logger de la clase
	 */
	Logger log = LoggerFactory.getLogger(UsuarioDAO.class);

	/**
	 * Objeto encargado de la conexion por jpa a la capa de datos
	 */
	private EntityManager entityManager;

	/**
	 * Constructor de la clase que instancia el this.entityManager.
     * @author Pablo Gavilan
     * @version 1.0
	 */
	public UsuarioDAO(){
		this.entityManager = Persistence.createEntityManagerFactory("funco-pu").createEntityManager();
	}

	/**
	 * Metodo encargado de insertar un usuario en la base de datos..
     * @author Pablo Gavilan
     * @version 1.0
	 */
	public void addUsuario(Usuario usu) throws Exception {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(usu);
			this.entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error e:" + e);
		}
	}

	public void delUsuario(Usuario usu) throws Exception {
		try {
			Usuario u = entityManager.find(Usuario.class, usu.getId());
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(u);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error e:" + e);
		}
	}

	public Usuario valUsuario(Usuario usu) throws Exception {
		try {
			String sql = "SELECT u FROM Usuario u WHERE u.clave = :clave and u.rut = :rut";
			TypedQuery<Usuario> q = entityManager.createQuery(sql, Usuario.class);

			q.setParameter("clave", usu.getClave());
			q.setParameter("rut", usu.getRut());
			return q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Usuario> listUsuario() throws Exception {
		
		try{
			log.info("antes de createNamedQuery " + Usuario.SQL_SELECT_ALL);
			return this.entityManager.createNamedQuery(Usuario.SQL_SELECT_ALL, Usuario.class).getResultList();	
		} catch (Exception e){
			log.error("Error al " + Usuario.SQL_SELECT_ALL);
			throw e;
		}
	}
}
