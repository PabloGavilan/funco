package cl.usach.diinf.huelen.funco.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import cl.usach.diinf.huelen.funco.ejb.UsuarioEJB;
import cl.usach.diinf.huelen.funco.entities.Usuario;

@Named
@RequestScoped
public class LoginBean {

	@EJB UsuarioEJB ejb;
	private String usu;
	private String clave;

    public String ingresar() {
        Usuario u = new Usuario();
        u.setRut(usu);
        u.setClave(clave);
		try {
			ejb.valUsuario(u);
			return "success";
		} catch (Exception e) {
			return "error";
		}
    }

	public String getUsu() {
		return this.usu;
	}

	public void setUsu(String usu) {
		this.usu = usu;
	}

	public String getPass() {
		return this.clave;
	}

	public void setPass(String pass) {
		this.clave = pass;
	}

	public LoginBean() {
		super();
	}
	
	@PostConstruct
	public void init(){
	}
	
}
