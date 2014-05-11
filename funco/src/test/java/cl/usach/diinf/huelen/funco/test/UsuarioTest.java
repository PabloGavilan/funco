package cl.usach.diinf.huelen.funco.test;

import cl.usach.diinf.huelen.funco.dao.UsuarioDAO;
import cl.usach.diinf.huelen.funco.entities.Usuario;
import junit.framework.TestCase;

public class UsuarioTest extends TestCase {

	public final String rut = "18278091";
	public final String nombre = "nom prueba";
	public final String apellidoMaterno = "apellidoMaterno prueba";
	public final String apellidoPaterno = "apellidoPaterno prueba";
	public final String dv = "0";
	public final String fechaNacimiento = "20140101";
	
	public void test() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usu = new Usuario();
		//usu.setApMaterno(apellidoMaterno);
		//usu.setApPaterno(apellidoPaterno);
		//usu.setDv(dv);
		//usu.setFecNacimiento(fechaNacimiento);
		//usu.setNombr(nombre);
		usu.setRut(rut);
		usu.setClave("123");
		//usu.setId(1);
		try {
			//dao.addUsuario(usu);
			//dao.delUsuario(usu);
			usu = dao.valUsuario(usu);
			System.out.println(usu.toString());
		}catch (Exception e) {
			fail("Error ");
		}
	}
}
