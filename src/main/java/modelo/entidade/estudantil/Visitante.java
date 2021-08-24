package modelo.entidade.estudantil;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.excecoes.LoginInvalidoException;
import modelo.excecoes.SenhaInvalidaException;

@Entity
@Table(name = "visitante")
public class Visitante extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visitante")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@MapsId
	@JoinColumn(name = "id_contato")
	private Contato contato;
	
	public Visitante () {}
	
	public Visitante (Long id, String login, String senha) throws LoginInvalidoException, SenhaInvalidaException {
		super(login, senha);
		setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}


}
