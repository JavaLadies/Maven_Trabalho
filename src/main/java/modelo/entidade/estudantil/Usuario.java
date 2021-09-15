package modelo.entidade.estudantil;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nome_usuario", length = 45, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "login_usuario", length = 30, nullable = false, unique = true)
	private String login;
	
	@Column(name = "senha_usuario", length = 30, nullable = false, unique = false)
	private String senha;

	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@MapsId
	@JoinColumn(name = "id_contato")
	private Contato contato;
	
	public Usuario() {}
	
	public Usuario(Long id) {
		setId(id);
	}
	
	public Usuario(String nome, String login, String senha, Contato contato)  {
		setNome(nome);
		setLogin(login);
		setSenha(senha);
		setContato(contato);
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Contato getContato() {

		return contato;
	}

	public void setContato(Contato contato) {

		this.contato = contato;
	}

}
