package modelo.entidades.jogo;

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

import modelo.entidade.estudantil.Disciplina;

@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_jogo")
	private Long id;
	
	//Um jogo tem vários mundos.
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Mundo> mundos = new ArrayList<Mundo>();
	
	//O jogo tem uma disciplina
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@MapsId
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	@Column(name = "media_jogo",nullable = true, unique = false)
	private float media;
	
	public Jogo() {}
	
	public Jogo(float media, Disciplina disciplina) {
		setDisciplina(disciplina);
		setMedia(media);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Mundo> getMundos() {
		return mundos;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public void adicionarMundo(Mundo mundo) {
		mundos.add(mundo);
		mundo.setJogo(this);
	}

	public void removerMundo(Mundo mundo) {
		mundos.remove(mundo);
		mundo.setJogo(null);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


}
