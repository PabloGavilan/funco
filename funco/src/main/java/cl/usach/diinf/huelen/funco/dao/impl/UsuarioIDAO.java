package cl.usach.diinf.huelen.funco.dao.impl;

import java.util.List;

import cl.usach.diinf.huelen.funco.entities.Usuario;

public interface UsuarioIDAO {

	public void addUsuario(Usuario usu) throws Exception;
	public void delUsuario(Usuario usu) throws Exception;
	public Usuario valUsuario(Usuario usu) throws Exception;
	public List<Usuario> listUsuario() throws Exception;
}
