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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.excecoes.LoginInvalidoException;
import modelo.excecoes.NomeInvalidoException;
import modelo.excecoes.SenhaInvalidaException;

@Entity
@Table(name = "escola")
public class Escola extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_escola")
	private Long id;
	
	@Column(name = "nome_escola", length = 45, nullable = false, unique = true)
	private String nome;
	
	//Escola tem um contato
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@MapsId
	@JoinColumn(name = "id_contato")
	private Contato contato;
	
	//Escolas tem várias turmas
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "escola", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Turma> turmas = new ArrayList<Turma>();

	public Escola() {}
	
	public Escola(Long id, String nome, Contato contato, String login, String senha)
			throws NomeInvalidoException, LoginInvalidoException, SenhaInvalidaException {
		super(login, senha);
		setId(id);
		setNome(nome);
		setContato(contato);
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

	public Contato getContato() {

		return contato;
	}

	public void setContato(Contato contato) {

		this.contato = contato;
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