package modelo.entidade.estudantil;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;
	
	@Column(name = "email_contato", length = 45, nullable = false, unique = true)
	private String email;
	
	@Column(name = "celular_contato", nullable = true, unique = false)
	private int celular;
	
	@Column(name = "telefone_contato", nullable = true, unique = false)
	private int telefone;

	public Contato() {}
	
	public Contato(Long id, String email, int celular, int telefone) {
		setId(id);
		setEmail(email);
		setCelular(celular);
		setTelefone(telefone);
	}

	public Contato(String email, int celular) {
		setEmail(email);
		setCelular(celular);
	}

	public Contato(String email) {
		setEmail(email);
	}

	public Contato(int telefone) {
		setTelefone(telefone);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email)  {

		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {

	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {

		this.telefone = telefone;
	}

}