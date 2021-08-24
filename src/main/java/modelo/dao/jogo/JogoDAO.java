package modelo.dao.jogo;

import java.util.List;

import modelo.entidades.jogo.Jogo;

public interface JogoDAO {
	
	void inserirJogo (Jogo jogo);
	
	void deletarJogo (Jogo jogo);
	
	void atualizarJogo (Jogo jogo);
	
	List<Jogo> recuperarJogos();
}
