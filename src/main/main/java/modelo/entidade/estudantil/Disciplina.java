package modelo.entidade.estudantil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import modelo.excecoes.NomeInvalidoException;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_disciplina")
	private Long id;
	
	@Column(name = "nome_disciplina", length = 45, nullable = false, unique = true)
	private String nome;
	
	//Uma disciplina tem várias turmas.
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "disciplina_turma", joinColumns = @JoinColumn(name = "id_disciplina"), inverseJoinColumns = @JoinColumn(name = "id_turma"))
	private List<Turma> turmas = new ArrayList<Turma>();

	public Disciplina() {}
	
	public Disciplina(Long id, String nome) throws NomeInvalidoException {
		setId(id);
		setNome(nome);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {

		if (nome.isEmpty())
			throw new NomeInvalidoException("Não pode ser vazio!");

		this.nome = nome;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void adicionarTurma(Turma turma) {
		turmas.add(turma);
	}

	public void adicionarDisciplinaNaTurma(Turma turma) {
		turma.adicionarDisciplina(this);
	}

	public void removerTurma(Turma turma) {
		turmas.remove(turma);
	}

	public void removerDisciplinaNaTurma(Turma turma) {
		turma.removerDisciplina(this);
	}

}