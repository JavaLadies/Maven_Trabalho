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
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	
	//Uma disciplina tem vários professores
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Professor> professores = new ArrayList<Professor>();
	
	//Uma disciplina tem várias turmas.
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "disciplina_turma", joinColumns = @JoinColumn(name = "id_disciplina"), inverseJoinColumns = @JoinColumn(name = "id_turma"))
	private List<Turma> turmas = new ArrayList<Turma>();

	public Disciplina() {}
	
	public Disciplina(Long id) {
		setId(id);
	}
	
	public Disciplina(String nome, Turma turma)  {
		setNome(nome);
		adicionarTurma(turma);
		adicionarDisciplinaNaTurma(turma);
		
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

	public void setNome(String nome) { 

		this.nome = nome;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public List<Professor> getProfessor () {
		return professores;
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