package modelo.entidade.estudantil;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.excecoes.LoginInvalidoException;

import modelo.excecoes.NomeInvalidoException;
import modelo.excecoes.SenhaInvalidaException;
import modelo.excecoes.pessoa.CpfInvalidoException;

@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long id;
	
	//Um aluno tem uma turma
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_turma")
	private Turma turma;

	public Aluno() {}
	
	public Aluno(Long id, String nome, String cpf, String login, String senha, Contato contato, Turma turma) throws NomeInvalidoException, CpfInvalidoException, 
			SenhaInvalidaException, LoginInvalidoException {
		
		super(nome, cpf, login, senha, contato);
		setId(id);
		setTurma(turma);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}


}