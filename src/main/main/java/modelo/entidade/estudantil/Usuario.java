package modelo.entidade.estudantil;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "login_usuario", length = 30, nullable = false, unique = true)
	private String login;
	
	@Column(name = "senha_usuario", length = 30, nullable = false, unique = false)
	private String senha;

	public Usuario() {}
	
	public Usuario(String login, String senha)  {
		setLogin(login);
		setSenha(senha);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login)  {

		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha)  {
	
		this.senha = senha;
	}

}
