package modelo.entidade.estudantil;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.excecoes.LoginInvalidoException;
import modelo.excecoes.NomeInvalidoException;
import modelo.excecoes.SenhaInvalidaException;
import modelo.excecoes.pessoa.CpfInvalidoException;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//O professor vai guardar o id de sua disciplina.
	@Id
	@Column(name = "id_disciplina")
	private Long id;
	
	//Um professor vai ter uma disciplina.
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@MapsId
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;

	public Professor() {}
	
	public Professor(Long id, String nome, String cpf, String login, String senha, Contato contato)
			throws NomeInvalidoException, CpfInvalidoException, SenhaInvalidaException, LoginInvalidoException {

		super(nome, cpf, login, senha, contato);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
