package modelo.entidade.estudantil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "escola")
public class Escola extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Escolas tem várias turmas
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "escola", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Escola() {}
	
	public Escola(String nome, Contato contato, String login, String senha) {
		super(nome, login, senha, contato);
		setNome(nome);
		setContato(contato);
	}

	public List<Turma> getTurmas (){
		return turmas;
	}

	public void adicionarTurma(Turma turma) {
		turmas.add(turma);
		turma.setEscola(this);
	}

	public void removerTurma(Turma turma) {
		turmas.remove(turma);
		turma.setEscola(null);
	}


}