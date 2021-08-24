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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.excecoes.NomeInvalidoException;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long id;
	
	@Column(name = "nome_turma", length = 30, nullable = false, unique = false)
	private String nome;
	
	//Uma escola tem muitas turmas.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escola")
	private Escola escola;
	
	//Uma turma tem muitos alunos.
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "turma", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Aluno> alunos;
	
	//Uma turma tem várias disciplinas.
	@ManyToMany(mappedBy = "turmas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Disciplina> disciplinas;

	public Turma() {
	}

	public Turma(Long id, String nome, Escola escola) throws NomeInvalidoException {
		setId(id);
		setNome(nome);
		setEscola(escola);
		disciplinas = new ArrayList<Disciplina>();
		alunos = new ArrayList<Aluno>();
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

	public Escola getEscola() {

		return escola;
	}

	public void setEscola(Escola escola) {

		this.escola = escola;
	}

	public List<Aluno> getAlunos() {

		return alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
		aluno.setTurma(this);
	}

	public void removerAluno(Aluno aluno) {
		alunos.remove(aluno);
		aluno.setTurma(null);

	}

	public void adicionarDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	public void adicionarTurmaDaDisciplina(Disciplina disciplina) {
		disciplina.adicionarTurma(this);
	}

	public void removerDisciplina(Disciplina disciplina) {
		disciplinas.remove(disciplina);
	}

	public void removerTurmaDaDisciplina(Disciplina disciplina) {
		disciplina.removerTurma(this);
	}

}