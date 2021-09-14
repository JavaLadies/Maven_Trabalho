package modelo.entidades.jogo;

import java.io.Serializable;



import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "atividade")
public class Atividade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Long id;
	
	@Column(name = "enunciado_atividade", length = 200, nullable = false, unique = false)
	private String enunciado;
	
	//Uma atividade terá uma fase (Uma fase terá muitas atividades)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fase")
	private Fase fase;
	
	//ENUM
	//@Column(name = "situacao_atividade", nullable = false, unique = false)
	//@Enumerated(EnumType.STRING)
	//private Situacao status;
	
	//Uma atividade tem várias opções.
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "atividade")
	private List<Opcao> opcoes;

	public Atividade () {}
	
	public Atividade(String enunciado, Fase fase) {
		setEnunciado(enunciado);
		setFase(fase);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	//public Situacao getStatus() {
	//	return status;
	//}

	//public void setStatus(Situacao status) {
	//	this.status = status;
	//}

	public void adicionarOpcao(Opcao opcao) {
		opcoes.add(opcao);
		opcao.setAtividade(this);
	}

	public void removerOpcao(Opcao opcao) {
		opcoes.remove(opcao);
		opcao.setAtividade(null);
	}




}
