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
@Table(name = "opcao")
public class Opcao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_opcao")
	private Long id;
	
	@Column(name = "texto_opcao", length = 200, nullable = false, unique = false)
	private String texto;
	
	@Column(name = "ordem_opcao", nullable = false, unique = false)
	private byte ordem;
	
	@Column(name = "isCorreta_opcao", nullable = false, unique = false)
	private boolean isCorreta;
	
	//Uma opcao terá uma atividade (Uma atividade terão várias opções)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_atividade")
	private Atividade atividade;

	public Opcao() {}
	
	public Opcao (String texto, byte ordem, boolean isCorreta, Atividade atividade) {
		setTexto(texto);
		setOrdem(ordem);
		setCorreta(isCorreta);
		setAtividade(atividade);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto () {
		return texto;
	}
	
	public void setTexto (String texto) {
		this.texto = texto;
	}

	public byte getOrdem() {
		return ordem;
	}

	public void setOrdem(byte ordem) {
		this.ordem = ordem;
	}

	public boolean isCorreta() {
		return isCorreta;
	}

	public void setCorreta(boolean isCorreta) {
		this.isCorreta = isCorreta;
	}
	
	public Atividade getAtividade () {
		return atividade;
	}
	
	public void setAtividade (Atividade atividade) {
		this.atividade = atividade;
	}

}
