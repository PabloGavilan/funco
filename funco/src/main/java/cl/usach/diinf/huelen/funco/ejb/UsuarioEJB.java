package cl.usach.diinf.huelen.funco.ejb;

import javax.ejb.Stateless;

import cl.usach.diinf.huelen.funco.dao.UsuarioDAO;
import cl.usach.diinf.huelen.funco.dao.impl.UsuarioIDAO;
import cl.usach.diinf.huelen.funco.entities.Usuario;

/**
 * <p>UsuarioEJB</p>
 * 
 * Clase encargada de la logica de negocio correspondiente a los usuarios.
 * 
 * @author Pablo Gavilan
 * @version 1.0
 *
 */
@Stateless public class UsuarioEJB{

	UsuarioIDAO dao;
	
	public UsuarioEJB() {
		dao = new UsuarioDAO();
	}

	public Usuario valUsuario(Usuario u) throws Exception {
		return dao.valUsuario(u);		
	}
}