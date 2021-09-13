package modelo.entidade.estudantil;


import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Professor extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Um professor vai ter uma disciplina.
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@MapsId
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;

	public Professor() {}
	
	public Professor(String nome, String login, String senha, Contato contato, Disciplina disciplina){ //throws NomeInvalidoException, CpfInvalidoException, SenhaInvalidaException, LoginInvalidoException
		super(nome, login, senha, contato);
		setDisciplina(disciplina);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
