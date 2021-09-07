package modelo.entidades.jogo;

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

@Entity
@Table(name = "teoria")
public class Teoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teoria")
	private Long id;
	
	@Column(name = "texto_teoria", length = 200, nullable = true, unique = false)
	private String texto;
	
	//Uma teoria terá uma fase (Uma fase tem várias teorias)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fase")
	private Fase fase;

	public Teoria() {}
	
	public Teoria(Long id, String texto, Fase fase) {
		setId(id);
		setTexto(texto);
		setFase(fase);
	}

	public Long getId() {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
}
